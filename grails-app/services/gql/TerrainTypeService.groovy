package gql

import grails.gorm.services.Service

@Service(TerrainType)
interface TerrainTypeService {

    TerrainType get(Serializable id)

    List<TerrainType> list(Map args)

    Long count()

    void delete(Serializable id)

    TerrainType save(TerrainType terrainType)

}