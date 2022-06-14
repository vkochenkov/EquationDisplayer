# EquationDisplayer
[![](https://jitpack.io/v/vkochenkov/EquationDisplayer.svg)](https://jitpack.io/#vkochenkov/EquationDisplayer)

Hello everyone!

If you use Jetpack Compose in your app and want to display different types of equation - welcome!
I started to create native library for displaying equations, using Compose.

The main goal is create DSL based on only one object - `EquationItem`. You can create and decorate this object for displaying different types of equations. By nesting one object into another, you get more variety.

## See some examples below
1) For display simplest example, add `EquationItem` object, set value in constructor and call compose functions `Show()` on the object:
<img src="https://user-images.githubusercontent.com/107124959/173685564-710d40f0-cfad-4504-ba10-701cc3a71501.jpg" style="width:800px;"/>

2) `EquationItem` has different parameters in constructor. Couple examples below:
<img src="https://user-images.githubusercontent.com/107124959/173686516-5b90b475-2fab-48f6-a757-3124b31cd7ef.jpg" style="width:800px;"/>
<img src="https://user-images.githubusercontent.com/107124959/173686602-a05bdb39-be75-4943-8774-0a89345c50b6.jpg" style="width:800px;"/>

3) You can mix parameters incide `EquationItem` and include one `EquationItem` inside another. But don't call `Show()` on inner EquationItems, it won't work!
<img src="https://user-images.githubusercontent.com/107124959/173687316-aacb4364-b856-4dc2-9126-9a3b5a6d775a.jpg" style="width:800px;"/>

4) You can place list incide `EquationItem` component. Also, note, that `Show()` function can take inside `FontParams` for decorate your equation visibility:
<img src="https://user-images.githubusercontent.com/107124959/173688109-692cbf70-87eb-4d0e-9519-95a026093038.jpg" style="width:800px;"/>

5) Finally, more complex example:
<img src="https://user-images.githubusercontent.com/107124959/173688233-a0ed2324-946d-4d05-8925-cfd10bc1fb33.jpg" style="width:800px;"/>

## Android SDK version requirements
- min sdk version: **21**
- target sdk version: **32**

## Using the lib in your gradle project
If you project use `gradle version '7.1.0'` or higher, add `maven { url 'https://jitpack.io' }` in your root `settings.gradle` file:
```
dependencyResolutionManagement {
    ...
    repositories {
        ...
        maven { url 'https://jitpack.io' }
    }
}
```
If you gradle version is lower, add it in your root `build.gradle` at the end of repositories:
```
allprojects {
    repositories {
      ...
      maven { url 'https://jitpack.io' }
    }
}
```
Finally, add dependency `'com.github.vkochenkov:EquationDisplayer:1.1'` in `build.gradle` dependencies section:
```
dependencies {
    ...
    implementation 'com.github.vkochenkov:EquationDisplayer:1.1'
}
```
## Feedback
I will be glad to hear any feedback from you. Please, connect me by email *kochenkov1993@gmail.com*


