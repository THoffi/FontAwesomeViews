<!-- https://guides.github.com/features/mastering-markdown/ -->
# FontAwesomeViews
Android FontAwesome Icon's integration


<img src="https://img.shields.io/badge/API-16%2B-brightgreen.svg" style="max-width:100%;"> [![](https://jitpack.io/v/THoffi/FontAwesomeViews.svg)](https://jitpack.io/#THoffi/FontAwesomeViews) [![License](https://img.shields.io/badge/License-Apache%202.0-blue.svg)](https://opensource.org/licenses/Apache-2.0)

### A simple library for using Font Awesome Icons for Android.<br>Including 1602 free icons (as of 10/2020).

<!-- from Issues -->
![FontAwesome2](https://user-images.githubusercontent.com/22442874/98095543-03532480-1e8b-11eb-86be-86ed8ca5f2e2.gif)
<br>

## Prerequisites
Add this in your root build.gradle file:
```java
allprojects {
    repositories {
     	...
        maven { url 'https://jitpack.io' }
    }
}
```

## Dependency
Add this to your module's build.gradle file:

```java
dependencies {
	...
	implementation 'com.github.THoffi:FontAwesomeViews:1.1.3'
}
```

---
## 1. FontAwesomeView
---
## Usage
Include the widget in your `xml` layout file:

```xml
<de.th.fontawesome.FontAwesomeView
        xmlns:custom="http://schemas.android.com/apk/res-auto"
	      ...
        android:id="@+id/viewFaTest1"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_margin="5dp"
	      ...
        custom:faIconSize="46"
        custom:faIconColor="#4CAF50"
        custom:faIcon="@string/fa_building" />
```

## Configuration

Change FontAwesome-Icon, Color and Size for 'FontAwesomeView' programmatically:
```java
 setFaIcon(Context context, int faIcon, int faIconColor, float faIconSize)
```

```java
 FontAwesomeView viewFaTest1 = findViewById(R.id.viewFaTest1);
 viewFaTest1.setFaIcon(context, R.string.fa_address_card, Color.RED, 36);
```

---
## 2. FontAwesomeButton
---
## Usage
Include the widget in your `xml` layout file:

```xml
<de.th.fontawesome.FontAwesomeButton
        xmlns:custom="http://schemas.android.com/apk/res-auto"
	     ...
        android:id="@+id/btnFaRating"
        android:layout_marginTop="20dp"
        android:layout_height="wrap_content"
        android:layout_width="match_parent"
        android:padding="1dp"
        android:background="#E8E4E4"
        android:text="RATING"
        android:textColor="#327777"
        android:textSize="18sp"
        android:gravity="start"
	     ...
        custom:faIcon="@string/fa_star"
        custom:faIconColor="#FFC107"
        custom:faIconSize="36"
        custom:faIconPadding="28"
        custom:faIconAlignment="LEFT"
        custom:faAnimateEffect="ROTATION"
        custom:faAnimateColor="#FBFBFB"
	     ...
        tools:ignore="HardcodedText" />
```
`faIconAlignment`
* LEFT
* RIGHT
* BOTTOM
* TOP

`faAnimateEffect`
* NONE
* ALPHA
* ROTATION
* BOUNCE
* RIPPLE

## Configuration

set ClickListener programmatically:
```java
 // FontAwesomeButton with ClickListener
 FontAwesomeButton faButton1 = findViewById(R.id.btnFaDonate);
 faButton1.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        Toast.makeText(getApplicationContext(),"Hello Donate Button",Toast.LENGTH_SHORT).show();
    }
 });
```

---
## 3. FontAwesome Drawable
---

## Configuration

set Drawable programmatically:
```java
   ...
 FloatingActionButton fab = findViewById(R.id.fab);
   ...
 de.th.fontawesome.FontAwesomeDrawable drawable = new de.th.fontawesome.FontAwesomeDrawable(this, R.string.fa_address_card);
 drawable.setTextColor(ContextCompat.getColor(this, android.R.color.white));
 
 fab.setImageDrawable(drawable);
   ...
```

## Changelog

* 1.0.1
	* Initial Release
* 1.1.3
	* Stable Release


## License

```txt
Copyright 2020 Torsten Hoffmann

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```
