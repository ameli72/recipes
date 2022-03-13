package com.andrewmeli.libraries.repository.mappers


interface IModelMapper<DTO, Model> {

    fun mapToModel(dto: DTO): Model

    fun mapFromModel(model: Model): DTO

    fun mapToModelList(dtos: List<DTO>): List<Model>
}