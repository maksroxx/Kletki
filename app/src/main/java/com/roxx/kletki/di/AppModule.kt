package com.roxx.kletki.di

import com.roxx.kletki.data.CellRepositoryImpl
import com.roxx.kletki.domain.repository.CellRepository
import com.roxx.kletki.domain.use_cases.AddNewCellUseCase
import com.roxx.kletki.domain.use_cases.GetCellUiModelsUseCase
import com.roxx.kletki.domain.use_cases.GetCellsUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideCellRepository(): CellRepository {
        return CellRepositoryImpl()
    }

    @Provides
    @Singleton
    fun provideAddNewCellUseCse(repository: CellRepository): AddNewCellUseCase {
        return AddNewCellUseCase(repository)
    }

    @Provides
    @Singleton
    fun provideGetCellsUseCase(repository: CellRepository): GetCellsUseCase {
        return GetCellsUseCase(repository)
    }

    @Provides
    @Singleton
    fun provideCellUiModelsUseCase(getCellsUseCase: GetCellsUseCase): GetCellUiModelsUseCase {
        return GetCellUiModelsUseCase(getCellsUseCase)
    }
}