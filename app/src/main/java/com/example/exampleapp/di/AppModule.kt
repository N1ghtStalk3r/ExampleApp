package com.example.exampleapp.di

import com.example.exampleapp.data.dataModule
import com.example.exampleapp.domain.domain
import com.example.exampleapp.ui.presentation

val allModules = dataModule + domain + presentation