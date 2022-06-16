# EquationDisplayer
[![](https://jitpack.io/v/vkochenkov/EquationDisplayer.svg)](https://jitpack.io/#vkochenkov/EquationDisplayer)

Hello everyone!

If you use Jetpack Compose in your app and want to display different types of equation - welcome!
I started to create native library for displaying equations, using Compose.

The main goal is create DSL based on only one object - `EquationItem`. You can create and decorate this object for displaying different types of equations. By nesting one object into another, you get more variety.

## See some examples below
1) For display simplest example, add `EquationItem` object, set value in constructor and call compose functions `Show()` on the object:
<img src="https://user-images.githubusercontent.com/107124959/174147618-c7503b7f-c06e-4c90-8b75-18de23e4f2a4.png" style="width:800px;"/>

2) `EquationItem` has different parameters in constructor. Couple examples below:
<img src="https://user-images.githubusercontent.com/107124959/174147662-d190a86a-213f-4d0a-8aa9-5ec9c55b8a99.png" style="width:800px;"/>

3) You can mix parameters incide `EquationItem` and include one `EquationItem` inside another. But don't call `Show()` on inner EquationItems, it won't work!
<img src="https://user-images.githubusercontent.com/107124959/174147707-57f87388-6f67-44c5-aeac-8705cb4a5fb5.png" style="width:800px;"/>

4) You can place list incide `EquationItem` component. Also, note, that `Show()` function can take inside `FontParams` for decorate your equation visibility:
<img src="https://user-images.githubusercontent.com/107124959/174147781-cbc06e11-1b40-4c96-8f2f-d165c12b8975.png" style="width:800px;"/>

5) Finally, more complex example:
<img src="https://user-images.githubusercontent.com/107124959/174147833-62c6d1e0-94de-4048-bfbc-0d169c1fc134.png" style="width:800px;"/>

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
Finally, add dependency `'com.github.vkochenkov:EquationDisplayer:1.2'` in `build.gradle` dependencies section:
```
dependencies {
    ...
    implementation 'com.github.vkochenkov:EquationDisplayer:1.2'
}
```
## Feedback
I will be glad to hear any feedback from you. Please, connect me by email *kochenkov1993@gmail.com*


