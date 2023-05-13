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
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityFreezeBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final ImageView CloseBut;

  @NonNull
  public final ImageView Corect;

  @NonNull
  public final TextView CountOfD;

  @NonNull
  public final TextView CountOfU;

  @NonNull
  public final EditText DataEdit;

  @NonNull
  public final ImageView baK;

  @NonNull
  public final ImageView imageView13;

  @NonNull
  public final ImageView imageView14;

  @NonNull
  public final ImageView imageView18;

  @NonNull
  public final ImageView imageView19;

  @NonNull
  public final ImageView imageView22;

  @NonNull
  public final ImageView imageView23;

  @NonNull
  public final ImageView imageView25;

  @NonNull
  public final ImageView imageView26;

  @NonNull
  public final ImageView imageView27;

  private ActivityFreezeBinding(@NonNull ConstraintLayout rootView, @NonNull ImageView CloseBut,
      @NonNull ImageView Corect, @NonNull TextView CountOfD, @NonNull TextView CountOfU,
      @NonNull EditText DataEdit, @NonNull ImageView baK, @NonNull ImageView imageView13,
      @NonNull ImageView imageView14, @NonNull ImageView imageView18,
      @NonNull ImageView imageView19, @NonNull ImageView imageView22,
      @NonNull ImageView imageView23, @NonNull ImageView imageView25,
      @NonNull ImageView imageView26, @NonNull ImageView imageView27) {
    this.rootView = rootView;
    this.CloseBut = CloseBut;
    this.Corect = Corect;
    this.CountOfD = CountOfD;
    this.CountOfU = CountOfU;
    this.DataEdit = DataEdit;
    this.baK = baK;
    this.imageView13 = imageView13;
    this.imageView14 = imageView14;
    this.imageView18 = imageView18;
    this.imageView19 = imageView19;
    this.imageView22 = imageView22;
    this.imageView23 = imageView23;
    this.imageView25 = imageView25;
    this.imageView26 = imageView26;
    this.imageView27 = imageView27;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityFreezeBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityFreezeBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_freeze, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityFreezeBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.CloseBut;
      ImageView CloseBut = ViewBindings.findChildViewById(rootView, id);
      if (CloseBut == null) {
        break missingId;
      }

      id = R.id.Corect;
      ImageView Corect = ViewBindings.findChildViewById(rootView, id);
      if (Corect == null) {
        break missingId;
      }

      id = R.id.CountOfD;
      TextView CountOfD = ViewBindings.findChildViewById(rootView, id);
      if (CountOfD == null) {
        break missingId;
      }

      id = R.id.CountOfU;
      TextView CountOfU = ViewBindings.findChildViewById(rootView, id);
      if (CountOfU == null) {
        break missingId;
      }

      id = R.id.DataEdit;
      EditText DataEdit = ViewBindings.findChildViewById(rootView, id);
      if (DataEdit == null) {
        break missingId;
      }

      id = R.id.baсk;
      ImageView baK = ViewBindings.findChildViewById(rootView, id);
      if (baK == null) {
        break missingId;
      }

      id = R.id.imageView13;
      ImageView imageView13 = ViewBindings.findChildViewById(rootView, id);
      if (imageView13 == null) {
        break missingId;
      }

      id = R.id.imageView14;
      ImageView imageView14 = ViewBindings.findChildViewById(rootView, id);
      if (imageView14 == null) {
        break missingId;
      }

      id = R.id.imageView18;
      ImageView imageView18 = ViewBindings.findChildViewById(rootView, id);
      if (imageView18 == null) {
        break missingId;
      }

      id = R.id.imageView19;
      ImageView imageView19 = ViewBindings.findChildViewById(rootView, id);
      if (imageView19 == null) {
        break missingId;
      }

      id = R.id.imageView22;
      ImageView imageView22 = ViewBindings.findChildViewById(rootView, id);
      if (imageView22 == null) {
        break missingId;
      }

      id = R.id.imageView23;
      ImageView imageView23 = ViewBindings.findChildViewById(rootView, id);
      if (imageView23 == null) {
        break missingId;
      }

      id = R.id.imageView25;
      ImageView imageView25 = ViewBindings.findChildViewById(rootView, id);
      if (imageView25 == null) {
        break missingId;
      }

      id = R.id.imageView26;
      ImageView imageView26 = ViewBindings.findChildViewById(rootView, id);
      if (imageView26 == null) {
        break missingId;
      }

      id = R.id.imageView27;
      ImageView imageView27 = ViewBindings.findChildViewById(rootView, id);
      if (imageView27 == null) {
        break missingId;
      }

      return new ActivityFreezeBinding((ConstraintLayout) rootView, CloseBut, Corect, CountOfD,
          CountOfU, DataEdit, baK, imageView13, imageView14, imageView18, imageView19, imageView22,
          imageView23, imageView25, imageView26, imageView27);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}