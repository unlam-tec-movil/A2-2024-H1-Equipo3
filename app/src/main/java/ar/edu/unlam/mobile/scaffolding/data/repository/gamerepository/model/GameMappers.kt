package ar.edu.unlam.mobile.scaffolding.data.repository.gamerepository.model

import ar.edu.unlam.mobile.scaffolding.domain.model.Game

fun GameEntity.toGameDto(): GameDto {
    return GameDto(
        userName = this.userName,
        score = this.score,
        date = this.date
    )
}

fun GameDto.toGameEntity(): GameEntity {
    return GameEntity(
        userName = this.userName,
        score = this.score,
        date = this.date
    )
}

fun Game.toGameDto(): GameDto {
    return GameDto(
        userName = this.userName,
        score = this.score,
        date = this.date
    )
}

fun GameDto.toGame(): Game {
    return Game(
        userName = this.userName,
        score = this.score,
        date = this.date
    )
}
