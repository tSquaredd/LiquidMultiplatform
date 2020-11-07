package com.tsquaredapps.liquidmultiplatform.androidApp.di

import com.tsquaredapps.liquidmultiplatform.shared.setup.information.UserInformationUseCaseImpl
import com.tsquaredapps.liquidmultiplatform.shared.setup.information.resources.UserInformationResources
import com.tsquaredapps.liquidmultiplatform.shared.setup.information.resources.UserInformationResourcesImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import kotlinx.coroutines.ExperimentalCoroutinesApi

@ExperimentalCoroutinesApi
@Module
@InstallIn(ApplicationComponent::class)
object UseCaseModule {

    @Provides
    fun provideUserInformationResources(): UserInformationResources = UserInformationResourcesImpl()

    @Provides
    fun findProvideUserInformationUseCase(resources: UserInformationResources): UserInformationUseCaseImpl =
        UserInformationUseCaseImpl(resources)
}