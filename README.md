# EquationDisplayer

Hello everyone!
I started to create native library for displaying equations, use Jetpack Compose.

### Current stable version: *beta-1.0.6*
Lib works on min sdk version: **21**, target sdk version: **32**.

On current time it seems like that: 
<img src="https://user-images.githubusercontent.com/107124959/173235770-2bf2009a-64bf-4f0b-b13e-395f4520331d.png" style="width:800px;"/>

## Try to use this lib in your project:

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
Finally, add dependency `'com.github.vkochenkov:EquationDisplayer:beta-1.0.1'` in `build.gradle` dependencies section:
```
dependencies {
    ...
    implementation 'com.github.vkochenkov:EquationDisplayer:beta-1.0.1'
}
```
I hoped you have a success.


