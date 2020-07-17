# LayoutViewPager
This library makes it possible to pass static layouts to display in ViewPager. This can be used for app introduction/tutorial with
horizontal swipes without having to create fragments for this.

## How to 
#### Gradle
```Gradle
dependencies {
    
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

#### Java Code
```kotlin
val layouts = arrayOf(R.layout.layout_1, R.layout.layout_2)
viewPager.setLayouts(layouts.toList())
viewPager.setCurrentPageListener(object : CurrentPageListener {
    override fun currentPageDisplayed(currentPosition: Int) {
       
    }
})
```