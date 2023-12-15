package com.lmkt.zupeshawar.db;

import java.util.List;

public interface CategoryDao {
    void deleteAllCategory();

    void deleteCategory(CategoryTB categoryTB);

    List<CategoryTB> getCategories();

    List<CategoryTB> getSubCategories(int i);

    void insertCategory(CategoryTB categoryTB);

    void updateCategory(CategoryTB categoryTB);
}
