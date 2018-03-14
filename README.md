# LiveData+ViewModel+Room的示例

### Android 架构组件 1.0 稳定版

> Google官方极力推荐架构组件库--它能帮您打造更稳定和易于测试的应用。稳定版适用于生产环境的应用或库。

### 相关链接

- 官网地址：https://developer.android.com/topic/libraries/architecture/adding-components.html
- 翻译文章：https://lovestack.github.io/2017/11/13/LiveData/

### 相关介绍

#### 1. LiveData

> 以下来自google官网原话
>
> [`LiveData`](https://developer.android.com/reference/android/arch/lifecycle/LiveData.html) is an observable data holder class. Unlike a regular observable, LiveData is lifecycle-aware, meaning it respects the lifecycle of other app components, such as activities, fragments, or services. This awareness ensures LiveData only updates app component observers that are in an active lifecycle state.
>
> **Note:** To import LiveData components into your Android project, see [Adding Components to your Project](https://developer.android.com/topic/libraries/architecture/adding-components.html).
>
> LiveData considers an observer, which is represented by the [`Observer`](https://developer.android.com/reference/android/arch/lifecycle/Observer.html) class, to be in an active state if its lifecycle is in the [`STARTED`](https://developer.android.com/reference/android/arch/lifecycle/Lifecycle.State.html#STARTED) or [`RESUMED`](https://developer.android.com/reference/android/arch/lifecycle/Lifecycle.State.html#RESUMED) state. LiveData only notifies active observers about updates. Inactive observers registered to watch [`LiveData`](https://developer.android.com/reference/android/arch/lifecycle/LiveData.html) objects aren't notified about changes.
>
> You can register an observer paired with an object that implements the [`LifecycleOwner`](https://developer.android.com/reference/android/arch/lifecycle/LifecycleOwner.html) interface. This relationship allows the observer to be removed when the state of the corresponding [`Lifecycle`](https://developer.android.com/reference/android/arch/lifecycle/Lifecycle.html) object changes to [`DESTROYED`](https://developer.android.com/reference/android/arch/lifecycle/Lifecycle.State.html#DESTROYED). This is especially useful for activities and fragments because they can safely observe [`LiveData`](https://developer.android.com/reference/android/arch/lifecycle/LiveData.html) objects and not worry about leaks—activities and fragments are instantly unsubscribed when their lifecycles are destroyed.
>
> For more information about how to use LiveData, see [Work with LiveData objects](https://developer.android.com/topic/libraries/architecture/livedata.html#work_livedata).

简而言之：Livedata是一个可观察的数据持有类，并且具有生命周期，可以与Activity、fragment、services绑定。当观察者的生命周期为started或者resumed的时候，livedata是活动的，并且会将相应的数据更新变化通知到该观察者，注册实现LifecycleOwner，可以在destroyed的时候，删除观察者，避免内存泄漏问题。

#### 2. ViewModel

> 以下来自google官网
>
> The [`ViewModel`](https://developer.android.com/reference/android/arch/lifecycle/ViewModel.html) class is designed to store and manage UI-related data in a lifecycle conscious way. The [`ViewModel`](https://developer.android.com/reference/android/arch/lifecycle/ViewModel.html) class allows data to survive configuration changes such as screen rotations.

简而言之：ViewModel是以生命周期的形式存储管理与UI有关的数据，并且不受屏幕旋转等影响。

#### 3.Room

> 以下来自google官网
>
> The Room persistence library provides an abstraction layer over SQLite to allow fluent database access while harnessing the full power of SQLite.
>
> The library helps you create a cache of your app's data on a device that's running your app. This cache, which serves as your app's single source of truth, allows users to view a consistent copy of key information within your app, regardless of whether users have an internet connection.

简而言之：Room持久库提供了SQLite的抽象层，可以充分利用SQLite的同时流畅的访问数据库。

### Demo实现

- 通过LiveData+ViewModel+Room 实现了通过RoomDataBase的Insert之后，数据自动回调刷新，并不需要自己手动再去添加刷新。
- 个人感觉一个很好的MVVM框架