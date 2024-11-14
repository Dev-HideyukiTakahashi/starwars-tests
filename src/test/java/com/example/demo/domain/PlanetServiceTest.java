package com.example.demo.domain;

import static com.example.demo.common.PlanetConstants.PLANET;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

/**
 * Teste unitário
 * Testando apenas o planetservice
 */

/*
 * Contexto da aplicação, para disponibilidade de injeção do'planetService'
 * Nesse caso não compensaria subir a aplicação toda para teste unitário
 */
// @SpringBootTest(classes = PlanetService.class)
@ExtendWith(MockitoExtension.class)
public class PlanetServiceTest {

  // @Autowired // sem spring não funciona
  @InjectMocks
  private PlanetService planetService;

  /*
   * dublê de teste do tipo mock criado para o repository
   * criado com base na classe, porém não é a implementação real
   */
  // @MockBean // sem spring não funciona
  @Mock
  private PlanetRepository planetRepository;

  /*
   * Padrão para nomear tests
   * operacao_estado_retorno
   */
  @Test
  public void createPlanet_WithValidData_ReturnsPlanet() {

    // Padrão AAA

    // ARRANGE
    // STUB, simulando o planetRepository
    when(planetRepository.save(PLANET))
        .thenReturn(PLANET);

    // ACT
    // sut = system under test
    Planet sut = planetService.create(PLANET);

    // ASSERT
    assertThat(sut).isEqualTo(PLANET);
  }
}
