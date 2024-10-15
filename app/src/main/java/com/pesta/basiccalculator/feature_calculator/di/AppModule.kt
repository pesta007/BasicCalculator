package com.pesta.basiccalculator.feature_calculator.di

import com.pesta.basiccalculator.feature_calculator.data.repository.ExpressionRepositoryImpl
import com.pesta.basiccalculator.feature_calculator.domain.repository.ExpressionRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class AppModule {
    @Singleton
    @Binds
    abstract fun bindExpressionRepository(expressionRepository: ExpressionRepositoryImpl): ExpressionRepository
}