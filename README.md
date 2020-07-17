[![](https://jitpack.io/v/Amal92/LayoutViewPager.svg)](https://jitpack.io/#Amal92/LayoutViewPager)

# LayoutViewPager
This library makes it possible to pass static layouts to display in ViewPager. This can be used for app introduction/tutorial with
horizontal swipes without having to create fragments for this.

## How to 
#### Gradle
Step 1. Add it in your root build.gradle at the end of repositories:
```Gradle
allprojects {
	repositories {
		...
		maven { url 'https://jitpack.io' }
    }
}
```
Step 2. Add the dependency:
```Gradle
dependencies {
    implementation 'com.github.Amal92:LayoutViewPager:<latest-version>'
}
```

#### In your XML layout
```Xml
<com.amp.view.LayoutViewPager
     android:id="@+id/viewPager"
     android:layout_width="match_parent"
     android:layout_height="match_parent"
     app:dotsColor="#A8A8A8"
     app:dotsStrokeColor="#A8A8A8" />
```

#### Custom Attributes
| Attribute | Description |
| --- | --- |
|`dotsColor`|Color of the indicator dot|
|`dotsStrokeColor`|Color of the unselected stroke dots|
|`enableDots`|True/False Whether to display dots indicator or not|

#### Kotlin Code
```kotlin
val layouts = arrayOf(R.layout.layout_1, R.layout.layout_2)
viewPager.setLayouts(layouts.toList())
viewPager.setCurrentPageListener(object : CurrentPageListener {
    override fun currentPageDisplayed(currentPosition: Int) {
       
    }
})
```