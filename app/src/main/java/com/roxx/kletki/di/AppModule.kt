package com.roxx.kletki.di

import android.app.Application
import androidx.room.Room
import com.roxx.kletki.data.local.CellDao
import com.roxx.kletki.data.local.CellDatabase
import com.roxx.kletki.data.repository.CellRepositoryImpl
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
    fun provideCellDatabase(app: Application): CellDatabase {
        return Room.databaseBuilder(
            app,
            CellDatabase::class.java,
            "cell_db"
        ).build()
    }

    @Provides
    @Singleton
    fun provideCellRepository(database: CellDatabase): CellRepository {
        return CellRepositoryImpl(dao = database.dao)
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