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

### Use OneUI icons

> **Warning**: Make sure you've imported OneUi icons library.

you need to use the `R` class from OneUI icons library:

```java
dev.oneuiproject.oneui.R.drawable
```

e.g. use home outline icon

```java
dev.oneuiproject.oneui.R.drawable.ic_oui_home_outline
```