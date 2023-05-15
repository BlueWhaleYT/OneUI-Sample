# OneUI Sample

This is a simple project which demonstrates how to utilize OneUI design library on Android.

## Github Repositories

- [oneui-core](https://github.com/OneUIProject/oneui-core)
- [oneui-design](https://github.com/OneUIProject/oneui-design)

## Quick notes

Here are some notes that for you getting started on using OneUI library.

### Dependencies

> **Warning**: You need to first **remove the original `appcompat` and `material` dependencies generated** in Android Studio.

```diff
- implementation 'androidx.appcompat:appcompat:1.6.1'
- implementation 'com.google.android.material:material:1.9.0'
- implementation 'androidx.constraintlayout:constraintlayout:2.1.4'
```

```gradle
implementation 'io.github.oneuiproject.sesl:appcompat:1.4.0'
implementation 'io.github.oneuiproject.sesl:material:1.5.0'
implementation 'io.github.oneuiproject:design:1.2.3'

// OneUI Preferences
implementation 'io.github.oneuiproject.sesl:preference:1.1.0'

// OneUI Icons
implementation 'io.github.oneuiproject:icons:1.0.1'
```

you need to add following code in `app/build.gradle` under the`dependencies` block.

```gradle
dependencies {
    ...
}

configurations.all {
    exclude group: 'androidx.appcompat', module: 'appcompat'
    exclude group: 'androidx.core', module: 'core'
}
```

### Theme settings

```xml
<application
    ...
    android:theme="@style/OneUITheme" />
```

### Widgets

#### Drawer

Define a `DrawerLayout` as the parent layout.

```xml
<dev.oneuiproject.oneui.layout.DrawerLayout 
    xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    android:id="@+id/drawerLayout"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    app:expanded="false"
    app:title="@string/app_name">
```

Now, set the items for the `DrawerLayout`, you need to define a `RecyclerView`.

> **Note**: You need to set `app:layout_location="drawer_panel`, this is to set the `RecyclerView` locates in the `DrawerLayout`.

```xml
<androidx.recyclerview.widget.RecyclerView
    android:id="@+id/drawer_list_view"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:scrollbars="vertical"
    app:layout_location="drawer_panel" />
```

##### Setup fragment list

> **Note**: `add(null)` means add a separator line

```java
private void setupFragmentList() {
    listFragment.add(new HomeFragment());
    listFragment.add(null);
    listFragment.add(new PreferencesFragment());
}
```

##### Setup fragments

```java
private void setupFragments() {
    fragmentManager = getSupportFragmentManager();
    FragmentTransaction transaction = fragmentManager.beginTransaction();
    for (Fragment fragment : listFragment) {
        if (fragment != null) transaction.add(R.id.frame_layout, fragment);
    }
    transaction.commit();
    fragmentManager.executePendingTransactions();
}
```

##### Setup drawer

```java
private void setupDrawer() {
    drawerListView.setLayoutManager(new LinearLayoutManager(this));
    drawerListView.setItemAnimator(null);
    drawerListView.setHasFixedSize(true);
    drawerListView.seslSetLastRoundedCorner(false);
    drawerListView.setAdapter(new DrawerListAdapter(this, listFragment, this));
}
```

Finally, in your `onCreate()` method:

```java
setupFragmentList();
setupFragments();
setupDrawer();
```

### Use OneUI icons

> **Warning**: Make sure you've imported OneUI icons library.

you need to use the `R` class from OneUI icons library:

```java
dev.oneuiproject.oneui.R
```

e.g. use home outline icon

```java
dev.oneuiproject.oneui.R.drawable.ic_oui_home_outline
```