<!-- https://guides.github.com/features/mastering-markdown/ -->
# FontAwesomeViews
Android FontAwesome Icon's integration


<img src="https://img.shields.io/badge/API-16%2B-brightgreen.svg" style="max-width:100%;"> [![](https://jitpack.io/v/THoffi/FontAwesomeViews.svg)](https://jitpack.io/#THoffi/FontAwesomeViews) [![License](https://img.shields.io/badge/License-Apache%202.0-blue.svg)](https://opensource.org/licenses/Apache-2.0)

### A simple library for using Font Awesome Icons for Android.<br>Including 1602 free icons (as of 10/2020).

<!-- from Issues -->
![FontAwesome1](https://user-images.githubusercontent.com/22442874/97815915-d556c000-1c91-11eb-953c-598c4f38f984.gif)
<!-- <img src="https://user-images.githubusercontent.com/22442874/97678701-8c85e800-1a94-11eb-8ed8-c113d2e2b55a.jpg"> -->
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
	implementation 'com.github.THoffi:FontAwesomeViews:1.1.2'
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
       	android:id="@+id/viewFaTest1"
       	android:layout_width="wrap_content"
     	android:layout_height="wrap_content"
      	android:layout_margin="5dp"
      	android:textSize="46sp"
     	android:textColor="#4CAF50"
      	custom:faIcon="@string/fa_building" />
```

## Configuration

Change FontAwesome-Icon and Color for 'FontAwesomeView' programmatically:

```java
viewFaTest1.setFaIcon(context, R.string.fa_address_card, Color.RED);
```

`onNumpadClicked(ArrayList<Integer> nums)` returns a `ArrayList<Integer>` of numbers that the user has entered till then. If the user presses delete when the arraylist is already empty, then it returns an empty arraylist.


Change the color of the button text:
```java
numpad.setButtonTextColor(@NonNull Context context, @NonNull int colorId);
```

Change color of numpad background
```xml
 <com.example.numpad.NumPad
 		...
        android:background="..."
     />

```

---
## 2. FontAwesomeButton
---
## Usage


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
