// Generated by view binder compiler. Do not edit!
package com.example.limeapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.limeapp.R;
import de.hdodenhof.circleimageview.CircleImageView;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ProfileActivityBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final ImageView DocButPrise;

  @NonNull
  public final ImageView ProfButPrise;

  @NonNull
  public final EditText editName;

  @NonNull
  public final ImageView imageView11;

  @NonNull
  public final ImageView imageView16;

  @NonNull
  public final ImageView imageView23;

  @NonNull
  public final ImageView imageView28;

  @NonNull
  public final ImageView imageView32;

  @NonNull
  public final ImageView imageView34;

  @NonNull
  public final ImageView imageView35;

  @NonNull
  public final ImageView imageView36;

  @NonNull
  public final ImageView imageView37;

  @NonNull
  public final ImageView imageView38;

  @NonNull
  public final ImageView priseButProf;

  @NonNull
  public final CircleImageView profileImage;

  @NonNull
  public final ImageView savedButton;

  @NonNull
  public final TextView textView4;

  @NonNull
  public final TextView textView8;

  private ProfileActivityBinding(@NonNull ConstraintLayout rootView, @NonNull ImageView DocButPrise,
      @NonNull ImageView ProfButPrise, @NonNull EditText editName, @NonNull ImageView imageView11,
      @NonNull ImageView imageView16, @NonNull ImageView imageView23,
      @NonNull ImageView imageView28, @NonNull ImageView imageView32,
      @NonNull ImageView imageView34, @NonNull ImageView imageView35,
      @NonNull ImageView imageView36, @NonNull ImageView imageView37,
      @NonNull ImageView imageView38, @NonNull ImageView priseButProf,
      @NonNull CircleImageView profileImage, @NonNull ImageView savedButton,
      @NonNull TextView textView4, @NonNull TextView textView8) {
    this.rootView = rootView;
    this.DocButPrise = DocButPrise;
    this.ProfButPrise = ProfButPrise;
    this.editName = editName;
    this.imageView11 = imageView11;
    this.imageView16 = imageView16;
    this.imageView23 = imageView23;
    this.imageView28 = imageView28;
    this.imageView32 = imageView32;
    this.imageView34 = imageView34;
    this.imageView35 = imageView35;
    this.imageView36 = imageView36;
    this.imageView37 = imageView37;
    this.imageView38 = imageView38;
    this.priseButProf = priseButProf;
    this.profileImage = profileImage;
    this.savedButton = savedButton;
    this.textView4 = textView4;
    this.textView8 = textView8;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ProfileActivityBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ProfileActivityBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.profile_activity, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ProfileActivityBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.DocButPrise;
      ImageView DocButPrise = ViewBindings.findChildViewById(rootView, id);
      if (DocButPrise == null) {
        break missingId;
      }

      id = R.id.ProfButPrise;
      ImageView ProfButPrise = ViewBindings.findChildViewById(rootView, id);
      if (ProfButPrise == null) {
        break missingId;
      }

      id = R.id.editName;
      EditText editName = ViewBindings.findChildViewById(rootView, id);
      if (editName == null) {
        break missingId;
      }

      id = R.id.imageView11;
      ImageView imageView11 = ViewBindings.findChildViewById(rootView, id);
      if (imageView11 == null) {
        break missingId;
      }

      id = R.id.imageView16;
      ImageView imageView16 = ViewBindings.findChildViewById(rootView, id);
      if (imageView16 == null) {
        break missingId;
      }

      id = R.id.imageView23;
      ImageView imageView23 = ViewBindings.findChildViewById(rootView, id);
      if (imageView23 == null) {
        break missingId;
      }

      id = R.id.imageView28;
      ImageView imageView28 = ViewBindings.findChildViewById(rootView, id);
      if (imageView28 == null) {
        break missingId;
      }

      id = R.id.imageView32;
      ImageView imageView32 = ViewBindings.findChildViewById(rootView, id);
      if (imageView32 == null) {
        break missingId;
      }

      id = R.id.imageView34;
      ImageView imageView34 = ViewBindings.findChildViewById(rootView, id);
      if (imageView34 == null) {
        break missingId;
      }

      id = R.id.imageView35;
      ImageView imageView35 = ViewBindings.findChildViewById(rootView, id);
      if (imageView35 == null) {
        break missingId;
      }

      id = R.id.imageView36;
      ImageView imageView36 = ViewBindings.findChildViewById(rootView, id);
      if (imageView36 == null) {
        break missingId;
      }

      id = R.id.imageView37;
      ImageView imageView37 = ViewBindings.findChildViewById(rootView, id);
      if (imageView37 == null) {
        break missingId;
      }

      id = R.id.imageView38;
      ImageView imageView38 = ViewBindings.findChildViewById(rootView, id);
      if (imageView38 == null) {
        break missingId;
      }

      id = R.id.priseButProf;
      ImageView priseButProf = ViewBindings.findChildViewById(rootView, id);
      if (priseButProf == null) {
        break missingId;
      }

      id = R.id.profile_image;
      CircleImageView profileImage = ViewBindings.findChildViewById(rootView, id);
      if (profileImage == null) {
        break missingId;
      }

      id = R.id.saved_button;
      ImageView savedButton = ViewBindings.findChildViewById(rootView, id);
      if (savedButton == null) {
        break missingId;
      }

      id = R.id.textView4;
      TextView textView4 = ViewBindings.findChildViewById(rootView, id);
      if (textView4 == null) {
        break missingId;
      }

      id = R.id.textView8;
      TextView textView8 = ViewBindings.findChildViewById(rootView, id);
      if (textView8 == null) {
        break missingId;
      }

      return new ProfileActivityBinding((ConstraintLayout) rootView, DocButPrise, ProfButPrise,
          editName, imageView11, imageView16, imageView23, imageView28, imageView32, imageView34,
          imageView35, imageView36, imageView37, imageView38, priseButProf, profileImage,
          savedButton, textView4, textView8);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}