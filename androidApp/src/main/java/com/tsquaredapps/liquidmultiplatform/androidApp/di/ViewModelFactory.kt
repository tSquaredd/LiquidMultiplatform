package com.tsquaredapps.liquidmultiplatform.androidApp.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.tsquaredapps.liquidmultiplatform.androidApp.setup.information.UserInformationViewModel
import dagger.Binds
import dagger.MapKey
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.multibindings.IntoMap
import javax.inject.Inject
import javax.inject.Provider
import javax.inject.Singleton
import kotlin.reflect.KClass

@Singleton
class ViewModelFactory
@Inject constructor(private val viewModels: MutableMap<Class<out ViewModel>, Provider<ViewModel>>) :
    ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T =
        viewModels[modelClass]?.get() as T

    @Target(
        AnnotationTarget.FUNCTION,
        AnnotationTarget.PROPERTY_GETTER,
        AnnotationTarget.PROPERTY_SETTER
    )
    @kotlin.annotation.Retention(AnnotationRetention.RUNTIME)
    @MapKey
    internal annotation class ViewModelKey(val value: KClass<out ViewModel>)

    @Module
    @InstallIn(ApplicationComponent::class)
    abstract class ViewModelModule {

        @Binds
        internal abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

        @Binds
        @IntoMap
        @ViewModelKey(UserInformationViewModel::class)
        internal abstract fun bindUserInformationViewModel(viewModel: UserInformationViewModel): ViewModel
    }
}