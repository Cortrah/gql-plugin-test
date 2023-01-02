package gql

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class TerrainTypeServiceSpec extends Specification {

    TerrainTypeService terrainTypeService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new TerrainType(...).save(flush: true, failOnError: true)
        //new TerrainType(...).save(flush: true, failOnError: true)
        //TerrainType terrainType = new TerrainType(...).save(flush: true, failOnError: true)
        //new TerrainType(...).save(flush: true, failOnError: true)
        //new TerrainType(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //terrainType.id
    }

    void "test get"() {
        setupData()

        expect:
        terrainTypeService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<TerrainType> terrainTypeList = terrainTypeService.list(max: 2, offset: 2)

        then:
        terrainTypeList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        terrainTypeService.count() == 5
    }

    void "test delete"() {
        Long terrainTypeId = setupData()

        expect:
        terrainTypeService.count() == 5

        when:
        terrainTypeService.delete(terrainTypeId)
        sessionFactory.currentSession.flush()

        then:
        terrainTypeService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        TerrainType terrainType = new TerrainType()
        terrainTypeService.save(terrainType)

        then:
        terrainType.id != null
    }
}
