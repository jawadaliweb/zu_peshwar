package com.google.firebase.database.core;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseException;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.InternalHelpers;
import java.util.HashMap;
import java.util.Map;

public class RepoManager {
    private static final RepoManager instance = new RepoManager();
    /* access modifiers changed from: private */
    public final Map<Context, Map<String, Repo>> repos = new HashMap();

    public static Repo getRepo(Context context, RepoInfo repoInfo) throws DatabaseException {
        return instance.getLocalRepo(context, repoInfo);
    }

    public static Repo createRepo(Context context, RepoInfo repoInfo, FirebaseDatabase firebaseDatabase) throws DatabaseException {
        return instance.createLocalRepo(context, repoInfo, firebaseDatabase);
    }

    public static void interrupt(Context context) {
        instance.interruptInternal(context);
    }

    public static void interrupt(final Repo repo) {
        repo.scheduleNow(new Runnable() {
            public void run() {
                Repo.this.interrupt();
            }
        });
    }

    public static void resume(final Repo repo) {
        repo.scheduleNow(new Runnable() {
            public void run() {
                Repo.this.resume();
            }
        });
    }

    public static void resume(Context context) {
        instance.resumeInternal(context);
    }

    public static void clear() {
        instance.clearRepos();
    }

    private void clearRepos() {
        synchronized (this.repos) {
            this.repos.clear();
        }
    }

    private Repo getLocalRepo(Context context, RepoInfo repoInfo) throws DatabaseException {
        Repo repo;
        context.freeze();
        String str = "https://" + repoInfo.host + "/" + repoInfo.namespace;
        synchronized (this.repos) {
            if (!this.repos.containsKey(context) || !this.repos.get(context).containsKey(str)) {
                InternalHelpers.createDatabaseForTests(FirebaseApp.getInstance(), repoInfo, (DatabaseConfig) context);
            }
            repo = (Repo) this.repos.get(context).get(str);
        }
        return repo;
    }

    private Repo createLocalRepo(Context context, RepoInfo repoInfo, FirebaseDatabase firebaseDatabase) throws DatabaseException {
        Repo repo;
        context.freeze();
        String str = "https://" + repoInfo.host + "/" + repoInfo.namespace;
        synchronized (this.repos) {
            if (!this.repos.containsKey(context)) {
                this.repos.put(context, new HashMap());
            }
            Map map = this.repos.get(context);
            if (!map.containsKey(str)) {
                repo = new Repo(repoInfo, context, firebaseDatabase);
                map.put(str, repo);
            } else {
                throw new IllegalStateException("createLocalRepo() called for existing repo.");
            }
        }
        return repo;
    }

    private void interruptInternal(final Context context) {
        RunLoop runLoop = context.getRunLoop();
        if (runLoop != null) {
            runLoop.scheduleNow(new Runnable() {
                public void run() {
                    boolean z;
                    synchronized (RepoManager.this.repos) {
                        if (RepoManager.this.repos.containsKey(context)) {
                            loop0:
                            while (true) {
                                z = true;
                                for (Repo repo : ((Map) RepoManager.this.repos.get(context)).values()) {
                                    repo.interrupt();
                                    if (!z || repo.hasListeners()) {
                                        z = false;
                                    }
                                }
                                break loop0;
                            }
                            if (z) {
                                context.stop();
                            }
                        }
                    }
                }
            });
        }
    }

    private void resumeInternal(final Context context) {
        RunLoop runLoop = context.getRunLoop();
        if (runLoop != null) {
            runLoop.scheduleNow(new Runnable() {
                public void run() {
                    synchronized (RepoManager.this.repos) {
                        if (RepoManager.this.repos.containsKey(context)) {
                            for (Repo resume : ((Map) RepoManager.this.repos.get(context)).values()) {
                                resume.resume();
                            }
                        }
                    }
                }
            });
        }
    }
}
