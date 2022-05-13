package com.example.recipeapp;

import android.app.Application;
import android.content.res.Resources;
import android.util.Log;

import androidx.annotation.NonNull;

import com.example.recipeapp.data.JSONRecipeParser;
import com.example.recipeapp.data.Recipe;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;
import java.util.Arrays;

public class RecipeController extends Application {
    private ArrayList<Recipe> recipes;

    @Override
    public void onCreate() {
        super.onCreate();
        recipes = new ArrayList<>();
    }

    public ArrayList<Recipe> getRecipes(){
        return recipes;
    }

    public void addRecipes(Recipe[] recipes){
        this.recipes.addAll(Arrays.asList(recipes));
    }

    public void addRecipe(Recipe recipe){
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        db.collection("recipes")
                .add(recipe)
                .addOnSuccessListener(documentReference -> Log.d("success", "DocumentSnapshot added with ID: " + documentReference.getId()))
                .addOnFailureListener(e -> Log.w("fail", "Error adding document", e));
    }

    public ArrayList<Recipe> queryExclude(ArrayList<String> exclude){
        return null;
    }
}