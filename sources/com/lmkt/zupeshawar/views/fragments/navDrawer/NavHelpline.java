package com.lmkt.zupeshawar.views.fragments.navDrawer;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import androidx.browser.trusted.sharing.ShareTarget;
import androidx.cardview.widget.CardView;
import androidx.core.net.MailTo;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import com.google.gson.JsonParser;
import com.kbeanie.multipicker.api.CacheLocation;
import com.lmkt.zupeshawar.R;
import com.lmkt.zupeshawar.Utilities.AppAlertDialog;
import com.lmkt.zupeshawar.Utilities.DocumentPicker;
import com.lmkt.zupeshawar.Utilities.SharedPrefrencesUtil;
import com.lmkt.zupeshawar.Utilities.ToastUtil;
import com.lmkt.zupeshawar.application.App;
import com.lmkt.zupeshawar.db.AppExecutors;
import com.lmkt.zupeshawar.db.CategoryTB;
import com.lmkt.zupeshawar.db.DBZuApp;
import com.lmkt.zupeshawar.model.QuestionAttachment;
import com.lmkt.zupeshawar.model.ReturnCodes;
import com.lmkt.zupeshawar.model.User;
import com.lmkt.zupeshawar.networkManager.APIManager;
import com.lmkt.zupeshawar.networkManager.ApiResponse;
import com.lmkt.zupeshawar.presenter.PickDocumentCallBack;
import com.lmkt.zupeshawar.recyclers.ImagesAdapter;
import com.lmkt.zupeshawar.views.activities.NavigationDrawerItemsActivity;
import com.lmkt.zupeshawar.views.adapters.CategoryAdapter;
import com.lmkt.zupeshawar.views.fragments.navDrawer.NavHelpline;
import es.dmoral.toasty.BuildConfig;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import org.apache.commons.compress.archivers.tar.TarConstants;
import org.json.JSONException;
import org.json.JSONObject;

public class NavHelpline extends Fragment implements ImagesAdapter.CancelBtnClicked, ImagesAdapter.ImageClicked, PickDocumentCallBack, View.OnClickListener, APIManager.Callback {
    private static final MediaType MEDIA_TYPE_JPEG = MediaType.parse("image/jpeg");
    private static final MediaType MEDIA_TYPE_JPG = MediaType.parse("image/jpg");
    private static final MediaType MEDIA_TYPE_PNG = MediaType.parse("image/png");
    CardView Btn_MakePhoneCall;
    CardView Btn_SendEmail;
    Button Btn_SendTicket;
    EditText ET_Details;
    RadioButton RB_Complaint;
    RadioButton RB_Suggestion;
    RadioGroup RG_TicketType;
    NavigationDrawerItemsActivity activity;
    ImagesAdapter adapter;
    /* access modifiers changed from: private */
    public CategoryTB categoryTB = null;
    public DocumentPicker documentPicker;
    ArrayList<QuestionAttachment> imageArray = new ArrayList<>();
    RecyclerView rvImages;
    private Spinner spinnerCategory;
    /* access modifiers changed from: private */
    public Spinner spinnerSubCategory;
    /* access modifiers changed from: private */
    public CategoryTB subCategoryTB = null;

    public void onImageClicked(ArrayList<QuestionAttachment> arrayList, int i) {
    }

    public void onPdfClicked(ArrayList<QuestionAttachment> arrayList, int i) {
    }

    public void onVideoClicked(ArrayList<QuestionAttachment> arrayList, int i) {
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.frag_navi_helpline, viewGroup, false);
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        try {
            initViews(view);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        this.documentPicker.onActivityResult(i, i2, intent);
    }

    public void initViews(View view) throws Exception {
        initDB();
        initToolbar();
        this.Btn_MakePhoneCall = (CardView) view.findViewById(R.id.Btn_MakePhoneCall);
        this.Btn_SendEmail = (CardView) view.findViewById(R.id.Btn_SendEmail);
        this.Btn_MakePhoneCall.setOnClickListener(this);
        this.Btn_SendEmail.setOnClickListener(this);
        Button button = (Button) view.findViewById(R.id.Btn_SendTicket);
        this.Btn_SendTicket = button;
        button.setOnClickListener(this);
        this.RG_TicketType = (RadioGroup) view.findViewById(R.id.RG_TicketType);
        this.RB_Suggestion = (RadioButton) view.findViewById(R.id.RB_Suggestion);
        this.RB_Complaint = (RadioButton) view.findViewById(R.id.RB_Complaint);
        this.ET_Details = (EditText) view.findViewById(R.id.ET_Details);
        this.rvImages = (RecyclerView) view.findViewById(R.id.rvImages);
        this.documentPicker = new DocumentPicker((Fragment) this, (PickDocumentCallBack) this);
        this.RB_Suggestion.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                NavHelpline.this.lambda$initViews$0$NavHelpline(compoundButton, z);
            }
        });
        this.RB_Complaint.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                NavHelpline.this.lambda$initViews$1$NavHelpline(compoundButton, z);
            }
        });
        this.spinnerCategory = (Spinner) view.findViewById(R.id.category);
        this.spinnerSubCategory = (Spinner) view.findViewById(R.id.subCategory);
        setupCategories();
        QuestionAttachment questionAttachment = new QuestionAttachment();
        questionAttachment.setType(4);
        if (!this.imageArray.contains(questionAttachment)) {
            this.imageArray.add(questionAttachment);
        }
        ImagesAdapter imagesAdapter = new ImagesAdapter(this, this.imageArray, false, true, this, this);
        this.adapter = imagesAdapter;
        this.rvImages.setAdapter(imagesAdapter);
    }

    public /* synthetic */ void lambda$initViews$0$NavHelpline(CompoundButton compoundButton, boolean z) {
        if (compoundButton.isChecked()) {
            this.ET_Details.setText("");
            this.ET_Details.setHint(R.string.txt_hint_writeSuggestionHere);
        }
    }

    public /* synthetic */ void lambda$initViews$1$NavHelpline(CompoundButton compoundButton, boolean z) {
        if (compoundButton.isChecked()) {
            this.ET_Details.setText("");
            this.ET_Details.setHint(R.string.txt_hint_writeComplaintHere);
        }
    }

    private void setupCategories() {
        AppExecutors.getInstance().diskIO().execute(new Runnable() {
            public final void run() {
                NavHelpline.this.lambda$setupCategories$3$NavHelpline();
            }
        });
    }

    public /* synthetic */ void lambda$setupCategories$3$NavHelpline() {
        List categories = DBZuApp.getInstance(this.activity).categoryDao().getCategories();
        if (categories == null) {
            categories = new ArrayList();
        }
        categories.add(0, new CategoryTB(-1, -1, getResources().getString(R.string.select_category)));
        AppExecutors.getInstance().mainThread().execute(new Runnable(categories) {
            public final /* synthetic */ List f$1;

            {
                this.f$1 = r2;
            }

            public final void run() {
                NavHelpline.this.lambda$setupCategories$2$NavHelpline(this.f$1);
            }
        });
    }

    public /* synthetic */ void lambda$setupCategories$2$NavHelpline(final List list) {
        this.spinnerCategory.setAdapter(new CategoryAdapter(getActivity(), R.layout.row_item_category, R.id.title, list));
        this.spinnerCategory.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onNothingSelected(AdapterView<?> adapterView) {
            }

            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
                CategoryTB unused = NavHelpline.this.categoryTB = (CategoryTB) list.get(i);
                AppExecutors.getInstance().diskIO().execute(new Runnable() {
                    public final void run() {
                        NavHelpline.AnonymousClass1.this.lambda$onItemSelected$1$NavHelpline$1();
                    }
                });
            }

            public /* synthetic */ void lambda$onItemSelected$1$NavHelpline$1() {
                List subCategories = DBZuApp.getInstance(NavHelpline.this.activity).categoryDao().getSubCategories(NavHelpline.this.categoryTB.id);
                if (subCategories == null) {
                    subCategories = new ArrayList();
                }
                subCategories.add(0, new CategoryTB(-1, -1, NavHelpline.this.getResources().getString(R.string.select_sub_category)));
                AppExecutors.getInstance().mainThread().execute(new Runnable(subCategories) {
                    public final /* synthetic */ List f$1;

                    {
                        this.f$1 = r2;
                    }

                    public final void run() {
                        NavHelpline.AnonymousClass1.this.lambda$onItemSelected$0$NavHelpline$1(this.f$1);
                    }
                });
            }

            public /* synthetic */ void lambda$onItemSelected$0$NavHelpline$1(final List list) {
                NavHelpline.this.spinnerSubCategory.setAdapter(new CategoryAdapter(NavHelpline.this.getActivity(), R.layout.row_item_category, R.id.title, list));
                NavHelpline.this.spinnerSubCategory.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    public void onNothingSelected(AdapterView<?> adapterView) {
                    }

                    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
                        CategoryTB unused = NavHelpline.this.subCategoryTB = (CategoryTB) list.get(i);
                    }
                });
            }
        });
    }

    private void initDB() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new CategoryTB(4, 0, "Operations"));
        arrayList.add(new CategoryTB(5, 0, "Website"));
        arrayList.add(new CategoryTB(6, 0, "Bus Service"));
        arrayList.add(new CategoryTB(7, 0, "Mobile App"));
        arrayList.add(new CategoryTB(8, 0, "Automated Fare Collection System"));
        arrayList.add(new CategoryTB(9, 0, "Lost and Found"));
        arrayList.add(new CategoryTB(10, 0, "Cleanliness"));
        arrayList.add(new CategoryTB(11, 0, "Misbehavior"));
        arrayList.add(new CategoryTB(12, 0, "Female related"));
        arrayList.add(new CategoryTB(13, 0, "Security Services"));
        arrayList.add(new CategoryTB(14, 0, "Screen Doors (PSD)"));
        arrayList.add(new CategoryTB(15, 0, "Pedestrian Ramps and Stairs"));
        arrayList.add(new CategoryTB(16, 4, "Punctuality of Buses"));
        arrayList.add(new CategoryTB(17, 4, "Overcrowding in buses"));
        arrayList.add(new CategoryTB(18, 5, "Bicycle Website is down"));
        arrayList.add(new CategoryTB(19, 6, "Sudden breaks by the driver"));
        arrayList.add(new CategoryTB(20, 6, "Improper docking of Buses at stations"));
        arrayList.add(new CategoryTB(21, 7, "Mobile App is not working"));
        arrayList.add(new CategoryTB(22, 7, "Mobile App is not up to date"));
        arrayList.add(new CategoryTB(23, 7, "Fare transaction are not correct"));
        arrayList.add(new CategoryTB(24, 0, "Generators Services"));
        arrayList.add(new CategoryTB(25, 0, "Escalator Services"));
        arrayList.add(new CategoryTB(28, 0, "Housekeeping  and Janitorial Services"));
        arrayList.add(new CategoryTB(29, 0, "Elevator Services"));
        arrayList.add(new CategoryTB(30, 0, "Corridor Management"));
        arrayList.add(new CategoryTB(31, 0, "Bicycle"));
        arrayList.add(new CategoryTB(32, 0, "Suggestions"));
        arrayList.add(new CategoryTB(33, 0, "Persons With Disabilities"));
        arrayList.add(new CategoryTB(36, 32, "General"));
        arrayList.add(new CategoryTB(37, 32, "Bus Operations"));
        arrayList.add(new CategoryTB(38, 32, "Security services suggestions"));
        arrayList.add(new CategoryTB(39, 32, "Janitorial Services"));
        arrayList.add(new CategoryTB(40, 32, "Card recharging"));
        arrayList.add(new CategoryTB(41, 32, "Card Management"));
        arrayList.add(new CategoryTB(42, 32, "Human Resource"));
        arrayList.add(new CategoryTB(43, 32, "Bicycle Sharing"));
        arrayList.add(new CategoryTB(44, 32, "Mobile App Suggestions"));
        arrayList.add(new CategoryTB(45, 32, "Female related Suggestions"));
        arrayList.add(new CategoryTB(46, 32, "Person With Disabilities"));
        arrayList.add(new CategoryTB(47, 32, "Any other suggestion"));
        arrayList.add(new CategoryTB(48, 31, "Kiosk not working"));
        arrayList.add(new CategoryTB(49, 31, "Kiosk is damaged"));
        arrayList.add(new CategoryTB(50, 31, "Kiosk is not accepting cash"));
        arrayList.add(new CategoryTB(51, 31, "Kiosk is not charging Zu card"));
        arrayList.add(new CategoryTB(52, 31, "Bicycle dock is not working"));
        arrayList.add(new CategoryTB(53, 31, "Bicycle is damaged"));
        arrayList.add(new CategoryTB(54, 31, "Number of bicycles are less"));
        arrayList.add(new CategoryTB(55, 31, "Docks are not available for bicycle parking"));
        arrayList.add(new CategoryTB(56, 31, "Bicycle are not available or distribution issue"));
        arrayList.add(new CategoryTB(57, 31, "Bicycle sharing website is down"));
        arrayList.add(new CategoryTB(58, 31, "Bicycle LED light is not working"));
        arrayList.add(new CategoryTB(59, 31, "Mechanical fault"));
        arrayList.add(new CategoryTB(60, 31, "Any other issue"));
        arrayList.add(new CategoryTB(61, 30, "Corridor in bad shape or uncomfortable"));
        arrayList.add(new CategoryTB(62, 30, "Corridor Crossing by pedestrian"));
        arrayList.add(new CategoryTB(63, 30, "Fencing in poor condition"));
        arrayList.add(new CategoryTB(64, 30, "Drainage issue in Corridor"));
        arrayList.add(new CategoryTB(65, 30, "Lights not ON in Corridor"));
        arrayList.add(new CategoryTB(66, 30, "Lights ON at daytime in corridor"));
        arrayList.add(new CategoryTB(78, 30, "Water leakage at Corridor"));
        arrayList.add(new CategoryTB(79, 30, "Graffiti on corridor"));
        arrayList.add(new CategoryTB(82, 29, "Elevators are not working"));
        arrayList.add(new CategoryTB(83, 29, "Non availability of elevator operator"));
        arrayList.add(new CategoryTB(84, 29, "Noise in Elevators"));
        arrayList.add(new CategoryTB(85, 29, "Safety issues in Elevators"));
        arrayList.add(new CategoryTB(86, 29, "Other issues"));
        arrayList.add(new CategoryTB(87, 28, "Cleaning staff not in proper uniform"));
        arrayList.add(new CategoryTB(88, 28, "Wash Room closed or access not granted"));
        arrayList.add(new CategoryTB(89, 28, "Water not available in wash rooms"));
        arrayList.add(new CategoryTB(90, 28, "Staff get money for use of Wash rooms"));
        arrayList.add(new CategoryTB(91, 28, "Washroom is not lit"));
        arrayList.add(new CategoryTB(92, 28, "Others"));
        arrayList.add(new CategoryTB(97, 25, "Non availability of Escalator operator"));
        arrayList.add(new CategoryTB(98, 25, "Noise in Escalators"));
        arrayList.add(new CategoryTB(99, 25, "Safety issues in Escalators"));
        arrayList.add(new CategoryTB(100, 25, "Other Escalator issues"));
        arrayList.add(new CategoryTB(101, 24, "Escalators are not working"));
        arrayList.add(new CategoryTB(102, 8, "Nonavailability of Zu cards"));
        arrayList.add(new CategoryTB(103, 8, "Crowding at ticket office"));
        arrayList.add(new CategoryTB(104, 8, "Lazy staff at ticket office"));
        arrayList.add(new CategoryTB(105, 8, "Ticket Vending Machine not working"));
        arrayList.add(new CategoryTB(106, 8, "Excess charging by ticket office"));
        arrayList.add(new CategoryTB(107, 8, "Staff not ready to accept currency bill greater than Rs 500"));
        arrayList.add(new CategoryTB(108, 8, "Excess deduction at Fare Gate"));
        arrayList.add(new CategoryTB(109, 8, "Ticket Vending Machine not accepting cash"));
        arrayList.add(new CategoryTB(110, 8, "Card cannot be charged from the internet"));
        arrayList.add(new CategoryTB(111, 8, "Issues in recharging of Zu card"));
        arrayList.add(new CategoryTB(112, 8, "Fare gate blocked or not working"));
        arrayList.add(new CategoryTB(113, 8, "Staff ID card is not displayed"));
        arrayList.add(new CategoryTB(114, 8, "Bus arrival information is not displayed at stations  in Buses"));
        arrayList.add(new CategoryTB(115, 8, "Passengers travelling without ticket"));
        arrayList.add(new CategoryTB(116, 8, "Long Queues at ticket office"));
        arrayList.add(new CategoryTB(117, 8, "Taking cash fare in the bus"));
        arrayList.add(new CategoryTB(118, 8, "Other Fare Collection Issues"));
        arrayList.add(new CategoryTB(119, 6, "Damage to buses"));
        arrayList.add(new CategoryTB(120, 6, "Screen not displaying information"));
        arrayList.add(new CategoryTB(121, 6, "No announcement in the bus"));
        arrayList.add(new CategoryTB(122, 6, "Low volume of announcement"));
        arrayList.add(new CategoryTB(123, 6, "Air Conditioned turned OFF in Bus or cooling not good"));
        arrayList.add(new CategoryTB(124, 6, "Wrong announcement in the Bus"));
        arrayList.add(new CategoryTB(125, 6, "Route map not provided or updated"));
        arrayList.add(new CategoryTB(126, 6, "Station Skipped"));
        arrayList.add(new CategoryTB(127, 6, "Accident"));
        arrayList.add(new CategoryTB(128, 6, "Driver didnt open the bus door"));
        arrayList.add(new CategoryTB(129, 6, "Driver used mobile while driving"));
        arrayList.add(new CategoryTB(130, 6, "Driver open door for very less time"));
        arrayList.add(new CategoryTB(TarConstants.PREFIXLEN_XSTAR, 6, "Bus stopped at nonscheduled station"));
        arrayList.add(new CategoryTB(132, 6, "Driver moved the bus before fully closing bus doors"));
        arrayList.add(new CategoryTB(133, 6, "Bus was travelling in night time without head lights ON"));
        arrayList.add(new CategoryTB(134, 6, "Bus was not lit inside in dark"));
        arrayList.add(new CategoryTB(135, 6, "Any other issues"));
        arrayList.add(new CategoryTB(136, 7, "Travel information is not correct"));
        arrayList.add(new CategoryTB(137, 7, "Any other Mobile App issue"));
        arrayList.add(new CategoryTB(138, 9, "Lost property in bus"));
        arrayList.add(new CategoryTB(139, 9, "Lost property at station"));
        arrayList.add(new CategoryTB(140, 10, "Station"));
        arrayList.add(new CategoryTB(141, 10, "Platform"));
        arrayList.add(new CategoryTB(BuildConfig.VERSION_CODE, 10, "Corridor"));
        arrayList.add(new CategoryTB(143, 10, "Dust Bins not available at Stations"));
        arrayList.add(new CategoryTB(144, 10, "Unclean Pedestrian Overhead /Underpasses"));
        arrayList.add(new CategoryTB(145, 10, "Escalators are unclean  dirty"));
        arrayList.add(new CategoryTB(146, 10, "PSD Doors are dirty and unclean"));
        arrayList.add(new CategoryTB(147, 10, "Water or slippery surface at station"));
        arrayList.add(new CategoryTB(TarConstants.CHKSUM_OFFSET, 10, "Bus"));
        arrayList.add(new CategoryTB(149, 11, "Misbehavior of Fare gate staff"));
        arrayList.add(new CategoryTB(150, 11, "Misbehavior of Bus Driver"));
        arrayList.add(new CategoryTB(151, 11, "Misbehavior of Bus Onboard Staff"));
        arrayList.add(new CategoryTB(152, 11, "Misbehavior of Ticket booth staff"));
        arrayList.add(new CategoryTB(153, 11, "Misbehavior of Platform staff"));
        arrayList.add(new CategoryTB(154, 11, "Misbehavior of Washroom /Toilet staff"));
        arrayList.add(new CategoryTB(TarConstants.PREFIXLEN, 11, "Misbehavior of Security Staff"));
        arrayList.add(new CategoryTB(156, 11, "Misbehavior of Escalator staff"));
        arrayList.add(new CategoryTB(157, 11, "Misbehavior of Janitorial staff"));
        arrayList.add(new CategoryTB(158, 11, "Misbehavior of Elevator staff"));
        arrayList.add(new CategoryTB(159, 11, "Misbehavior of Any other staff"));
        arrayList.add(new CategoryTB(160, 12, "Female washrooms used by male"));
        arrayList.add(new CategoryTB(161, 12, "Female section of bus is used"));
        arrayList.add(new CategoryTB(162, 12, "by male passenger(s)"));
        arrayList.add(new CategoryTB(163, 12, "Male standing in female queue"));
        arrayList.add(new CategoryTB(164, 12, "Male using front bus door"));
        arrayList.add(new CategoryTB(165, 13, "Staff are missing at station"));
        arrayList.add(new CategoryTB(166, 13, "Female staff are missing at station"));
        arrayList.add(new CategoryTB(167, 13, "No proper security checks at station"));
        arrayList.add(new CategoryTB(168, 13, "Staff Smoking at stations"));
        arrayList.add(new CategoryTB(169, 13, "Staff Identity Card is not displayed"));
        arrayList.add(new CategoryTB(170, 13, "Staff using Mobile during duty"));
        arrayList.add(new CategoryTB(171, 13, "Staff not in proper uniform"));
        arrayList.add(new CategoryTB(172, 13, "Staff in shabby uniform"));
        arrayList.add(new CategoryTB(173, 13, "Vehicle other than Zu bus entered the corridor"));
        arrayList.add(new CategoryTB(174, 13, "Passengers Smoking at station"));
        arrayList.add(new CategoryTB(175, 13, "Staff not using Metal detector"));
        arrayList.add(new CategoryTB(176, 13, "Someone damaged Zu Peshawar Infrastructure"));
        arrayList.add(new CategoryTB(177, 13, "Pickpocketing/ property stolen at stations and buses"));
        arrayList.add(new CategoryTB(178, 13, "Indecent behavior by passenger at stations"));
        arrayList.add(new CategoryTB(179, 13, "Staff not helping passengers"));
        arrayList.add(new CategoryTB(180, 13, "Staff not making queue"));
        arrayList.add(new CategoryTB(181, 13, "Other Security Issues"));
        arrayList.add(new CategoryTB(182, 13, "Fire extinguisher missing"));
        arrayList.add(new CategoryTB(183, 14, "PSD doors not opening with Zu bus doors"));
        arrayList.add(new CategoryTB(184, 14, "Safety issues in PSD Doors"));
        arrayList.add(new CategoryTB(185, 14, "Unnecessary sound from PSD Doors"));
        arrayList.add(new CategoryTB(186, 14, "Other PSD issues"));
        arrayList.add(new CategoryTB(187, 15, "Ramps are Slippery"));
        arrayList.add(new CategoryTB(188, 15, "Tripping Hazard"));
        arrayList.add(new CategoryTB(191, 0, "Fault"));
        arrayList.add(new CategoryTB(192, 191, "Physical Damage"));
        arrayList.add(new CategoryTB(193, 191, "Power Outage"));
        arrayList.add(new CategoryTB(194, 191, "Netowrk Disconnection"));
        arrayList.add(new CategoryTB(195, 191, "Replacement"));
        arrayList.add(new CategoryTB(198, 24, "Out of Order"));
        arrayList.add(new CategoryTB(204, 0, "Public Address System at Stations"));
        arrayList.add(new CategoryTB(205, 204, "No Announcement Working at Stations"));
        arrayList.add(new CategoryTB(206, 204, "Wrong Announcement at Stations"));
        arrayList.add(new CategoryTB(207, 204, "Noise during Announcement"));
        arrayList.add(new CategoryTB(208, 204, "Announcement at Wrong Location"));
        arrayList.add(new CategoryTB(209, 33, "Designated Washroom is being used by general public"));
        arrayList.add(new CategoryTB(210, 33, "Bus Seats and facilities of disable are used by others"));
        arrayList.add(new CategoryTB(212, 0, "Passenger Information Display"));
        arrayList.add(new CategoryTB(213, 212, "Arrival Information not Display in Buses"));
        arrayList.add(new CategoryTB(214, 212, "Arrival Information Not Display at Stations"));
        arrayList.add(new CategoryTB(215, 212, "Other issues Relevant to PID"));
        arrayList.add(new CategoryTB(216, 10, "Other relevant issues"));
        arrayList.add(new CategoryTB(217, 33, "Other issues relevant to PWD"));
        arrayList.add(new CategoryTB(218, 15, "Stairs are difficult to Climb"));
        arrayList.add(new CategoryTB(219, 15, "Other issues related to Ramps and Stairs"));
        arrayList.add(new CategoryTB(220, 30, "Other issues related to  Corridor"));
        arrayList.add(new CategoryTB(221, 0, "Station Management"));
        arrayList.add(new CategoryTB(222, 221, "Drainage Issue at Station"));
        arrayList.add(new CategoryTB(223, 221, "Lights not On at Stations"));
        arrayList.add(new CategoryTB(224, 221, "Lack of Facilities at Station"));
        arrayList.add(new CategoryTB(225, 221, "Lights ON at day time at Stations"));
        arrayList.add(new CategoryTB(226, 221, "Fans not Working at Stations"));
        arrayList.add(new CategoryTB(227, 221, "Fans not ON at Stations"));
        arrayList.add(new CategoryTB(228, 221, "Missing Sign Board at Stations"));
        arrayList.add(new CategoryTB(229, 221, "Lack of Information at Station"));
        arrayList.add(new CategoryTB(230, 30, "Safety and Security of Corridor"));
        arrayList.add(new CategoryTB(231, 30, "Illegal vehicle entered in Corridor"));
        arrayList.add(new CategoryTB(232, 221, "Drinking Water not Available at Stations"));
        arrayList.add(new CategoryTB(233, 221, "Water Cooler Not Working"));
        arrayList.add(new CategoryTB(234, 221, "Water Cooler Water is Dirty"));
        arrayList.add(new CategoryTB(235, 221, "Water Cooler Water is Hot"));
        arrayList.add(new CategoryTB(236, 221, "Glass Breaking Issue at Stations"));
        arrayList.add(new CategoryTB(237, 221, "Late Opening or Early Closing of Ticket Office"));
        arrayList.add(new CategoryTB(238, 221, "Access to Station is not Safe"));
        arrayList.add(new CategoryTB(239, 221, "Safety Issue at Zebra Crossing"));
        arrayList.add(new CategoryTB(240, 221, "Safety Issue at Stations"));
        arrayList.add(new CategoryTB(241, 221, "Water Leakage Issue at Stations"));
        arrayList.add(new CategoryTB(242, 221, "Graffiti on Stations"));
        arrayList.add(new CategoryTB(243, 221, "No Wi Fi at Stations"));
        arrayList.add(new CategoryTB(244, 221, "Motorcycle Flying on Pedestrian Bridges"));
        arrayList.add(new CategoryTB(245, 221, "Illegal Hawkers at Pedestrian Bridges and Underpassess"));
        arrayList.add(new CategoryTB(246, 6, "No Wi Fi in Buses"));
        arrayList.add(new CategoryTB(247, 221, "Other Issue relevant to Station Management"));
        arrayList.add(new CategoryTB(248, 32, "Suggestion about Station Management"));
        arrayList.add(new CategoryTB(249, 0, "Hayatabad Commercial Area"));
        arrayList.add(new CategoryTB(250, 249, "Complaint on Janitorial Services"));
        arrayList.add(new CategoryTB(251, 4, "Mobile"));
        arrayList.add(new CategoryTB(252, 5, "Mobile"));
        arrayList.add(new CategoryTB(253, 6, "Mobile"));
        arrayList.add(new CategoryTB(254, 7, "Mobile"));
        arrayList.add(new CategoryTB(255, 8, "Mobile"));
        arrayList.add(new CategoryTB(256, 9, "Mobile"));
        arrayList.add(new CategoryTB(257, 10, "Mobile"));
        arrayList.add(new CategoryTB(BZip2Constants.MAX_ALPHA_SIZE, 11, "Mobile"));
        arrayList.add(new CategoryTB(259, 12, "Mobile"));
        arrayList.add(new CategoryTB(260, 13, "Mobile"));
        arrayList.add(new CategoryTB(261, 14, "Mobile"));
        arrayList.add(new CategoryTB(262, 15, "Mobile"));
        arrayList.add(new CategoryTB(TarConstants.VERSION_OFFSET, 24, "Mobile"));
        arrayList.add(new CategoryTB(264, 25, "Mobile"));
        arrayList.add(new CategoryTB(265, 28, "Mobile"));
        arrayList.add(new CategoryTB(266, 29, "Mobile"));
        arrayList.add(new CategoryTB(267, 30, "Mobile"));
        arrayList.add(new CategoryTB(268, 31, "Mobile"));
        arrayList.add(new CategoryTB(269, 32, "Mobile"));
        arrayList.add(new CategoryTB(270, 33, "Mobile"));
        arrayList.add(new CategoryTB(271, 191, "Mobile"));
        arrayList.add(new CategoryTB(272, 204, "Mobile"));
        arrayList.add(new CategoryTB(273, 212, "Mobile"));
        arrayList.add(new CategoryTB(274, 221, "Mobile"));
        arrayList.add(new CategoryTB(275, 249, "Mobile"));
        arrayList.add(new CategoryTB(276, 4, "Website"));
        arrayList.add(new CategoryTB(277, 5, "Website"));
        arrayList.add(new CategoryTB(278, 6, "Website"));
        arrayList.add(new CategoryTB(279, 7, "Website"));
        arrayList.add(new CategoryTB(280, 8, "Website"));
        arrayList.add(new CategoryTB(281, 9, "Website"));
        arrayList.add(new CategoryTB(282, 10, "Website"));
        arrayList.add(new CategoryTB(283, 11, "Website"));
        arrayList.add(new CategoryTB(284, 12, "Website"));
        arrayList.add(new CategoryTB(285, 13, "Website"));
        arrayList.add(new CategoryTB(286, 14, "Website"));
        arrayList.add(new CategoryTB(287, 15, "Website"));
        arrayList.add(new CategoryTB(288, 24, "Website"));
        arrayList.add(new CategoryTB(289, 25, "Website"));
        arrayList.add(new CategoryTB(290, 28, "Website"));
        arrayList.add(new CategoryTB(291, 29, "Website"));
        arrayList.add(new CategoryTB(292, 30, "Website"));
        arrayList.add(new CategoryTB(293, 31, "Website"));
        arrayList.add(new CategoryTB(294, 32, "Website"));
        arrayList.add(new CategoryTB(295, 33, "Website"));
        arrayList.add(new CategoryTB(296, 191, "Website"));
        arrayList.add(new CategoryTB(297, 204, "Website"));
        arrayList.add(new CategoryTB(298, 212, "Website"));
        arrayList.add(new CategoryTB(299, 221, "Website"));
        arrayList.add(new CategoryTB(CacheLocation.EXTERNAL_CACHE_DIR, 249, "Website"));
        AppExecutors.getInstance().diskIO().execute(new Runnable(arrayList) {
            public final /* synthetic */ List f$0;

            {
                this.f$0 = r1;
            }

            public final void run() {
                NavHelpline.lambda$initDB$4(this.f$0);
            }
        });
    }

    static /* synthetic */ void lambda$initDB$4(List list) {
        try {
            DBZuApp.getInstance(App.getInstance()).categoryDao().deleteAllCategory();
            Iterator it = list.iterator();
            while (it.hasNext()) {
                DBZuApp.getInstance(App.getInstance()).categoryDao().insertCategory((CategoryTB) it.next());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void initToolbar() {
        NavigationDrawerItemsActivity navigationDrawerItemsActivity = (NavigationDrawerItemsActivity) getActivity();
        this.activity = navigationDrawerItemsActivity;
        navigationDrawerItemsActivity.mToolbar_Title.setText(R.string.title_Complaints);
        this.activity.mToolbar_LeftBtn.setVisibility(8);
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.Btn_MakePhoneCall:
                startActivity(new Intent("android.intent.action.DIAL", Uri.fromParts("tel", "091111477477", (String) null)));
                return;
            case R.id.Btn_SendEmail:
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.setData(Uri.parse(MailTo.MAILTO_SCHEME + "zu@brt.com" + "?subject=" + "ZuPeshawar Complaint" + "&body=" + "Complaint Here"));
                startActivity(intent);
                return;
            case R.id.Btn_SendTicket:
                if (this.ET_Details.getText().toString().equals("")) {
                    ToastUtil.showToast(ToastUtil.ToastType.error, "Please Enter Details");
                    return;
                }
                CategoryTB categoryTB2 = this.categoryTB;
                if (categoryTB2 == null || categoryTB2.id == -1) {
                    ToastUtil.ToastType toastType = ToastUtil.ToastType.error;
                    ToastUtil.showToast(toastType, "Please " + getResources().getString(R.string.select_category));
                    return;
                }
                CategoryTB categoryTB3 = this.subCategoryTB;
                if (categoryTB3 == null || categoryTB3.id == -1) {
                    ToastUtil.ToastType toastType2 = ToastUtil.ToastType.error;
                    ToastUtil.showToast(toastType2, "Please " + getResources().getString(R.string.select_sub_category));
                    return;
                }
                this.activity.appAlerts.showPleaseWait(this.activity);
                submit();
                return;
            default:
                return;
        }
    }

    private void submit() {
        if (!this.imageArray.get(0).getAttachmentUrl().endsWith("jpg")) {
            boolean endsWith = this.imageArray.get(0).getAttachmentUrl().endsWith("jpeg");
        }
        new JsonParser();
        MultipartBody.Builder builder = new MultipartBody.Builder();
        builder.setType(MultipartBody.FORM);
        User userObject_Prefrences = SharedPrefrencesUtil.getUserObject_Prefrences(this.activity);
        builder.addFormDataPart("Name", userObject_Prefrences.getName());
        builder.addFormDataPart("email", userObject_Prefrences.getEmail());
        builder.addFormDataPart("Phone", userObject_Prefrences.getMobileNumber());
        builder.addFormDataPart("CategoryID", String.valueOf(this.categoryTB.id));
        builder.addFormDataPart("SubCategoryID", String.valueOf(this.subCategoryTB.id));
        builder.addFormDataPart("subject", "Complaint");
        builder.addFormDataPart("Station", "DUMMY");
        builder.addFormDataPart("route", "DUMMY");
        builder.addFormDataPart("direction", "DUMMY");
        builder.addFormDataPart("detail", this.ET_Details.getText().toString());
        builder.addFormDataPart("upload_data", "complaint", RequestBody.create(MediaType.parse(ShareTarget.ENCODING_TYPE_MULTIPART), this.imageArray.get(0).getAttachmentFile()));
        APIManager.getInstance().postUserTicket(this, builder.build(), getContext());
    }

    private JSONObject createJsonRequest() {
        User userObject_Prefrences = SharedPrefrencesUtil.getUserObject_Prefrences(this.activity);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("Name", userObject_Prefrences.getName());
            jSONObject.put("email", userObject_Prefrences.getEmail());
            jSONObject.put("Phone", userObject_Prefrences.getMobileNumber());
            jSONObject.put("subject", "Complaint");
            jSONObject.put("Station", "DUMMY");
            jSONObject.put("route", "DUMMY");
            jSONObject.put("direction", "DUMMY");
            jSONObject.put("detail", this.ET_Details.getText().toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    public void onSuccess(int i, ApiResponse apiResponse) {
        this.activity.appAlerts.dismiss();
        if (i == ReturnCodes.Companion.OK()) {
            this.activity.appAlerts.showSuccessDialog(this.activity, apiResponse.getRespMessage(), new AppAlertDialog.AlertDialogListener() {
                public final void onClicked() {
                    NavHelpline.this.lambda$onSuccess$5$NavHelpline();
                }
            });
            return;
        }
        this.activity.appAlerts.dismiss();
        this.activity.appAlerts.showErrorDialog(this.activity, apiResponse.getRespMessage(), new AppAlertDialog.AlertDialogListener() {
            public final void onClicked() {
                NavHelpline.this.lambda$onSuccess$6$NavHelpline();
            }
        });
    }

    public /* synthetic */ void lambda$onSuccess$5$NavHelpline() {
        this.activity.appAlerts.dismiss();
        this.activity.onBackPressed();
    }

    public /* synthetic */ void lambda$onSuccess$6$NavHelpline() {
        this.activity.appAlerts.dismiss();
    }

    public void onFailure(int i, String str) {
        this.activity.appAlerts.dismiss();
        this.activity.appAlerts.showErrorDialog(this.activity, str, new AppAlertDialog.AlertDialogListener() {
            public final void onClicked() {
                NavHelpline.this.lambda$onFailure$7$NavHelpline();
            }
        });
    }

    public /* synthetic */ void lambda$onFailure$7$NavHelpline() {
        this.activity.appAlerts.dismiss();
    }

    public void onDocumentPicked(QuestionAttachment questionAttachment) {
        this.imageArray.add(questionAttachment);
        this.adapter.notifyDataSetChanged();
    }

    public void cancelBtnClicked(int i) {
        this.imageArray.remove(i);
        this.adapter.notifyDataSetChanged();
    }

    public void openDocument() {
        this.documentPicker.openDocumentPicker(false, false, (String) null);
    }
}
