package com.cetys.loading.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.cetys.loading.model.BaseCategory;
import com.cetys.loading.model.BaseQuestion;

@Service
public class BaseQuestionService {

        public static List<BaseQuestion> getDefaultBaseQuestions(List<BaseCategory> categories) {

                return Arrays.asList(
                                // Categoría 1: Materiales innecesarios (S1)
                                BaseQuestion.builder()
                                                .question("¿Hay materias primas innecesarias o en exceso en el área?")
                                                .baseCategory(categories.get(0))
                                                .build(),
                                BaseQuestion.builder()
                                                .question("¿Existen productos terminados o inventario obsoleto o sin identificación?")
                                                .baseCategory(categories.get(0))
                                                .build(),
                                BaseQuestion.builder()
                                                .question("¿Los EPP están completos y en buen estado (sin elementos innecesarios)?")
                                                .baseCategory(categories.get(0))
                                                .build(),
                                BaseQuestion.builder()
                                                .question("¿Existe un sistema claro para identificar y gestionar scrap y residuos?")
                                                .baseCategory(categories.get(0))
                                                .build(),
                                BaseQuestion.builder()
                                                .question("¿Los materiales de uso diario y pallets están organizados y solo los necesarios?")
                                                .baseCategory(categories.get(0))
                                                .build(),

                                // Categoría 2: Herramientas innecesarias (S1)
                                BaseQuestion.builder()
                                                .question("¿Existen herramientas innecesarias, duplicadas o en mal estado?")
                                                .baseCategory(categories.get(1))
                                                .build(),
                                BaseQuestion.builder()
                                                .question("¿Los accesorios en general están clasificados y solo los necesarios están en el área?")
                                                .baseCategory(categories.get(1))
                                                .build(),
                                BaseQuestion.builder()
                                                .question("¿Se ha identificado y retirado el material de limpieza roto u obsoleto?")
                                                .baseCategory(categories.get(1))
                                                .build(),
                                BaseQuestion.builder()
                                                .question("¿El mobiliario y equipos informáticos son los necesarios para las tareas del área?")
                                                .baseCategory(categories.get(1))
                                                .build(),

                                // Categoría 3: Máquinas o equipos innecesarios (S1)
                                BaseQuestion.builder()
                                                .question("¿Existen máquinas o partes de máquinas innecesarias u obsoletas en el área?")
                                                .baseCategory(categories.get(2))
                                                .build(),
                                BaseQuestion.builder()
                                                .question("¿Los equipos de transporte y manipulación (auto-elevadores, apiladores, zorras) son los necesarios?")
                                                .baseCategory(categories.get(2))
                                                .build(),

                                // Categoría 4: Documentos innecesarios (S1)
                                BaseQuestion.builder()
                                                .question("¿La documentación de seguridad está actualizada y sin versiones obsoletas?")
                                                .baseCategory(categories.get(3))
                                                .build(),
                                BaseQuestion.builder()
                                                .question("¿La documentación de calidad está vigente y sin duplicados innecesarios?")
                                                .baseCategory(categories.get(3))
                                                .build(),
                                BaseQuestion.builder()
                                                .question("¿La documentación operativa está actualizada y solo la necesaria?")
                                                .baseCategory(categories.get(3))
                                                .build(),
                                BaseQuestion.builder()
                                                .question("¿Las órdenes de producción están organizadas y se eliminan las completadas/obsoletas?")
                                                .baseCategory(categories.get(3))
                                                .build(),

                                // Categoría 5: Etiquetaje (S1)
                                BaseQuestion.builder()
                                                .question("¿Existe un procedimiento claro de etiquetaje de 5S para items innecesarios?")
                                                .baseCategory(categories.get(4))
                                                .build(),
                                BaseQuestion.builder()
                                                .question("¿Existe un área designada y señalizada para materiales innecesarios (red tag area)?")
                                                .baseCategory(categories.get(4))
                                                .build(),
                                BaseQuestion.builder()
                                                .question("¿Se utiliza correctamente el sistema de etiquetado para identificar elementos a descartar?")
                                                .baseCategory(categories.get(4))
                                                .build(),

                                // Categoría 6: IDENTIFICACIÓN (S2)
                                BaseQuestion.builder()
                                                .question("¿Los productos peligrosos están claramente identificados con señalización adecuada?")
                                                .baseCategory(categories.get(5))
                                                .build(),
                                BaseQuestion.builder()
                                                .question("¿Las máquinas y equipos de apoyo están identificados con nombre/código visible?")
                                                .baseCategory(categories.get(5))
                                                .build(),
                                BaseQuestion.builder()
                                                .question("¿Las líneas de producción están identificadas con nombres o códigos estandarizados?")
                                                .baseCategory(categories.get(5))
                                                .build(),
                                BaseQuestion.builder()
                                                .question("¿Los silos y tuberías están identificados con contenido, dirección y riesgos?")
                                                .baseCategory(categories.get(5))
                                                .build(),
                                BaseQuestion.builder()
                                                .question("¿Cada estación de trabajo está identificada con nombre/función/responsable?")
                                                .baseCategory(categories.get(5))
                                                .build(),
                                BaseQuestion.builder()
                                                .question("¿Los escritorios y equipos informáticos están identificados por usuario/función?")
                                                .baseCategory(categories.get(5))
                                                .build(),
                                BaseQuestion.builder()
                                                .question("¿Los equipos de seguridad y EPP están identificados y localizados adecuadamente?")
                                                .baseCategory(categories.get(5))
                                                .build(),
                                BaseQuestion.builder()
                                                .question("¿Las herramientas y equipos de limpieza están identificados y en ubicaciones marcadas?")
                                                .baseCategory(categories.get(5))
                                                .build(),

                                // Categoría 7: ORGANIZACIÓN (S2)
                                BaseQuestion.builder()
                                                .question("¿Los accesorios y herramientas están organizados según frecuencia de uso?")
                                                .baseCategory(categories.get(6))
                                                .build(),
                                BaseQuestion.builder()
                                                .question("¿Los equipos de seguridad están organizados para fácil acceso en caso de emergencia?")
                                                .baseCategory(categories.get(6))
                                                .build(),
                                BaseQuestion.builder()
                                                .question("¿Las herramientas de limpieza y consumibles están organizadas por tipo y uso?")
                                                .baseCategory(categories.get(6))
                                                .build(),
                                BaseQuestion.builder()
                                                .question("¿El mobiliario está organizado de manera eficiente para optimizar el flujo de trabajo?")
                                                .baseCategory(categories.get(6))
                                                .build(),
                                BaseQuestion.builder()
                                                .question("¿Existe un lugar específico para cada elemento con indicación visual?")
                                                .baseCategory(categories.get(6))
                                                .build(),

                                // Categoría 8: DEMARCACIÓN (S2)
                                BaseQuestion.builder()
                                                .question("¿El área de acabado está claramente demarcada con líneas/señalización?")
                                                .baseCategory(categories.get(7))
                                                .build(),
                                BaseQuestion.builder()
                                                .question("¿Las áreas de residuos están demarcadas por tipo de residuo?")
                                                .baseCategory(categories.get(7))
                                                .build(),
                                BaseQuestion.builder()
                                                .question("¿Las áreas de suministros están demarcadas según tipo de material?")
                                                .baseCategory(categories.get(7))
                                                .build(),
                                BaseQuestion.builder()
                                                .question("¿Las estaciones de trabajo tienen límites claramente marcados?")
                                                .baseCategory(categories.get(7))
                                                .build(),
                                BaseQuestion.builder()
                                                .question("¿Las áreas de productos peligrosos están demarcadas con señalización de riesgo?")
                                                .baseCategory(categories.get(7))
                                                .build(),
                                BaseQuestion.builder()
                                                .question("¿Las sendas peatonales están claramente marcadas y libres de obstáculos?")
                                                .baseCategory(categories.get(7))
                                                .build(),
                                BaseQuestion.builder()
                                                .question("¿Las áreas de máquinas y zonas de no acceso están correctamente señalizadas?")
                                                .baseCategory(categories.get(7))
                                                .build(),

                                // Categoría 9: Kanban (S2)
                                BaseQuestion.builder()
                                                .question("¿El sistema Kanban para productos terminados está implementado y respetado?")
                                                .baseCategory(categories.get(8))
                                                .build(),
                                BaseQuestion.builder()
                                                .question("¿Existe un sistema visual para gestión de residuos/waste?")
                                                .baseCategory(categories.get(8))
                                                .build(),
                                BaseQuestion.builder()
                                                .question("¿El control visual de materia prima/suministros permite identificar niveles mínimos?")
                                                .baseCategory(categories.get(8))
                                                .build(),
                                BaseQuestion.builder()
                                                .question("¿Los elementos de seguridad tienen un sistema visual para control de stock/estado?")
                                                .baseCategory(categories.get(8))
                                                .build(),
                                BaseQuestion.builder()
                                                .question("¿Los residuos están separados según tipo con identificación clara?")
                                                .baseCategory(categories.get(8))
                                                .build(),
                                BaseQuestion.builder()
                                                .question("¿Existe un sistema visual para control de elementos y herramientas de limpieza?")
                                                .baseCategory(categories.get(8))
                                                .build(),

                                // Categoría 10: Documentos necesarios (S2)
                                BaseQuestion.builder()
                                                .question("¿Las órdenes de producción están visibles, accesibles y organizadas?")
                                                .baseCategory(categories.get(9))
                                                .build(),
                                BaseQuestion.builder()
                                                .question("¿La documentación de seguridad está disponible, visible y organizada?")
                                                .baseCategory(categories.get(9))
                                                .build(),
                                BaseQuestion.builder()
                                                .question("¿La documentación de calidad está accesible donde se necesita?")
                                                .baseCategory(categories.get(9))
                                                .build(),
                                BaseQuestion.builder()
                                                .question("¿Los procedimientos operativos están organizados y fácilmente consultables?")
                                                .baseCategory(categories.get(9))
                                                .build(),
                                BaseQuestion.builder()
                                                .question("¿Existe un sistema de organización para documentos (físicos/digitales)?")
                                                .baseCategory(categories.get(9))
                                                .build(),

                                // Categoría 11: Herramientas de limpieza (S3)
                                BaseQuestion.builder()
                                                .question("¿Los productos de limpieza están disponibles, identificados y almacenados correctamente?")
                                                .baseCategory(categories.get(10))
                                                .build(),
                                BaseQuestion.builder()
                                                .question("¿Los materiales y equipos de limpieza están en buen estado y organizados?")
                                                .baseCategory(categories.get(10))
                                                .build(),
                                BaseQuestion.builder()
                                                .question("¿Existe un procedimiento de limpieza detallado para todas las áreas y equipos?")
                                                .baseCategory(categories.get(10))
                                                .build(),
                                BaseQuestion.builder()
                                                .question("¿Los procedimientos de limpieza incluyen frecuencia, responsable y método?")
                                                .baseCategory(categories.get(10))
                                                .build(),

                                // Categoría 12: Limpieza estaciones (S3)
                                BaseQuestion.builder()
                                                .question("¿Las máquinas y estaciones de trabajo están limpias y sin acumulación de residuos?")
                                                .baseCategory(categories.get(11))
                                                .build(),
                                BaseQuestion.builder()
                                                .question("¿Las tuberías y bombas están limpias y sin fugas o derrames?")
                                                .baseCategory(categories.get(11))
                                                .build(),
                                BaseQuestion.builder()
                                                .question("¿Los armarios y estanterías están limpios interna y externamente?")
                                                .baseCategory(categories.get(11))
                                                .build(),
                                BaseQuestion.builder()
                                                .question("¿El área de segregación de residuos está limpia y organizada?")
                                                .baseCategory(categories.get(11))
                                                .build(),

                                // Categoría 13: Eliminación suciedad (S3)
                                BaseQuestion.builder()
                                                .question("¿Se identifican y abordan las fuentes de suciedad en máquinas y estaciones?")
                                                .baseCategory(categories.get(12))
                                                .build(),
                                BaseQuestion.builder()
                                                .question("¿Se realiza mantenimiento preventivo en tuberías y bombas para evitar fugas?")
                                                .baseCategory(categories.get(12))
                                                .build(),
                                BaseQuestion.builder()
                                                .question("¿Los armarios y estanterías tienen un sistema para prevenir acumulación de polvo?")
                                                .baseCategory(categories.get(12))
                                                .build(),
                                BaseQuestion.builder()
                                                .question("¿Existen medidas preventivas en el área de residuos para evitar contaminación?")
                                                .baseCategory(categories.get(12))
                                                .build(),
                                BaseQuestion.builder()
                                                .question("¿Las oficinas de producción y cabinas de control mantienen estándares de limpieza?")
                                                .baseCategory(categories.get(12))
                                                .build(),

                                // Categoría 14: Limpieza pisos (S3)
                                BaseQuestion.builder()
                                                .question("¿Los pisos y corredores están limpios, secos y sin obstáculos?")
                                                .baseCategory(categories.get(13))
                                                .build(),
                                BaseQuestion.builder()
                                                .question("¿Las áreas de residuos tienen pisos limpios y sin contaminación cruzada?")
                                                .baseCategory(categories.get(13))
                                                .build(),
                                BaseQuestion.builder()
                                                .question("¿Toda la iluminación funciona correctamente y está limpia?")
                                                .baseCategory(categories.get(13))
                                                .build(),
                                BaseQuestion.builder()
                                                .question("¿Las paredes y techos están limpios y en buen estado?")
                                                .baseCategory(categories.get(13))
                                                .build(),
                                BaseQuestion.builder()
                                                .question("¿Existe un programa de limpieza para pisos con horarios establecidos?")
                                                .baseCategory(categories.get(13))
                                                .build(),

                                // Categoría 15: Comportamientos limpieza (S3)
                                BaseQuestion.builder()
                                                .question("¿Se cumple la rutina de limpieza diaria por parte de todo el personal?")
                                                .baseCategory(categories.get(14))
                                                .build(),
                                BaseQuestion.builder()
                                                .question("¿Los checklists de limpieza/gestión autónoma de máquinas y equipos están actualizados?")
                                                .baseCategory(categories.get(14))
                                                .build(),
                                BaseQuestion.builder()
                                                .question("¿Los checklists de limpieza de equipos de movimiento de materiales están actualizados?")
                                                .baseCategory(categories.get(14))
                                                .build(),
                                BaseQuestion.builder()
                                                .question("¿Los uniformes y EPP se mantienen limpios y en buen estado?")
                                                .baseCategory(categories.get(14))
                                                .build(),
                                BaseQuestion.builder()
                                                .question("¿Existe cultura de 'limpiar mientras trabajas' en todos los empleados?")
                                                .baseCategory(categories.get(14))
                                                .build(),

                                // Categoría 16: Estándares visuales (S4)
                                BaseQuestion.builder()
                                                .question("¿Las tuberías están identificadas con código de colores según contenido/dirección?")
                                                .baseCategory(categories.get(15))
                                                .build(),
                                BaseQuestion.builder()
                                                .question("¿Las máquinas y equipos tienen controles visuales para identificar el estado normal?")
                                                .baseCategory(categories.get(15))
                                                .build(),
                                BaseQuestion.builder()
                                                .question("¿Las herramientas tienen control visual para su ubicación y estado?")
                                                .baseCategory(categories.get(15))
                                                .build(),
                                BaseQuestion.builder()
                                                .question("¿Las áreas y puestos de trabajo tienen ayudas visuales para mantener el orden?")
                                                .baseCategory(categories.get(15))
                                                .build(),
                                BaseQuestion.builder()
                                                .question("¿Los escritorios y salas de reuniones tienen estándares visuales de organización?")
                                                .baseCategory(categories.get(15))
                                                .build(),

                                // Categoría 17: Estándares organización (S4)
                                BaseQuestion.builder()
                                                .question("¿Existen estándares visuales de limpieza con imágenes del 'antes y después'?")
                                                .baseCategory(categories.get(16))
                                                .build(),
                                BaseQuestion.builder()
                                                .question("¿El estándar de descarte está documentado y visible para todos?")
                                                .baseCategory(categories.get(16))
                                                .build(),
                                BaseQuestion.builder()
                                                .question("¿Los estándares de organización son conocidos y aplicados por todos?")
                                                .baseCategory(categories.get(16))
                                                .build(),
                                BaseQuestion.builder()
                                                .question("¿Existen auditorías periódicas para verificar cumplimiento de estándares?")
                                                .baseCategory(categories.get(16))
                                                .build(),

                                // Categoría 18: Procedimientos operativos (S4)
                                BaseQuestion.builder()
                                                .question("¿Los estándares de salud y seguridad están documentados y visibles?")
                                                .baseCategory(categories.get(17))
                                                .build(),
                                BaseQuestion.builder()
                                                .question("¿Los estándares operativos son claros, actualizados y accesibles?")
                                                .baseCategory(categories.get(17))
                                                .build(),
                                BaseQuestion.builder()
                                                .question("¿Los estándares de calidad están integrados en los procedimientos diarios?")
                                                .baseCategory(categories.get(17))
                                                .build(),
                                BaseQuestion.builder()
                                                .question("¿Existe un sistema para actualizar y comunicar cambios en procedimientos?")
                                                .baseCategory(categories.get(17))
                                                .build(),

                                // Categoría 19: Materiales consumo (S4)
                                BaseQuestion.builder()
                                                .question("¿Los materiales de consumo/productos tienen estándares de almacenamiento visibles?")
                                                .baseCategory(categories.get(18))
                                                .build(),
                                BaseQuestion.builder()
                                                .question("¿Las materias primas tienen estándares de manipulación y almacenamiento claros?")
                                                .baseCategory(categories.get(18))
                                                .build(),
                                BaseQuestion.builder()
                                                .question("¿Existe control visual para niveles mínimos y máximos de inventario?")
                                                .baseCategory(categories.get(18))
                                                .build(),

                                // Categoría 20: Gestión 5S (S4)
                                BaseQuestion.builder()
                                                .question("¿Existen carteleras específicas de 5S para cada máquina y equipo crítico?")
                                                .baseCategory(categories.get(19))
                                                .build(),
                                BaseQuestion.builder()
                                                .question("¿Hay una cartelera general de 5S para el área completa?")
                                                .baseCategory(categories.get(19))
                                                .build(),
                                BaseQuestion.builder()
                                                .question("¿El tablero de comunicación del área está actualizado con información relevante?")
                                                .baseCategory(categories.get(19))
                                                .build(),
                                BaseQuestion.builder()
                                                .question("¿El plan de acción de la auditoría se implementa dentro de los 10 días posteriores?")
                                                .baseCategory(categories.get(19))
                                                .build(),
                                BaseQuestion.builder()
                                                .question("¿El plan de acción de la última auditoría está publicado en las carteleras?")
                                                .baseCategory(categories.get(19))
                                                .build(),

                                // Categoría 21: Estándares 5S (S4)
                                BaseQuestion.builder()
                                                .question("¿El estándar 5S está definido con imágenes claras y descripciones detalladas?")
                                                .baseCategory(categories.get(20))
                                                .build(),
                                BaseQuestion.builder()
                                                .question("¿Los checklist de 5S asociados al estándar están definidos y en uso?")
                                                .baseCategory(categories.get(20))
                                                .build(),
                                BaseQuestion.builder()
                                                .question("¿Los estándares 5S son revisados y actualizados periódicamente?")
                                                .baseCategory(categories.get(20))
                                                .build(),

                                // Categoría 22: Programa 5S (S5)
                                BaseQuestion.builder()
                                                .question("¿Se realizan reuniones periódicas de 5S del área con reportes documentados?")
                                                .baseCategory(categories.get(21))
                                                .build(),
                                BaseQuestion.builder()
                                                .question("¿Las auditorías de 5S se realizan según cronograma y están disponibles en el área?")
                                                .baseCategory(categories.get(21))
                                                .build(),
                                BaseQuestion.builder()
                                                .question("¿Todos los auditores designados han cumplido con las últimas dos auditorías planificadas?")
                                                .baseCategory(categories.get(21))
                                                .build(),
                                BaseQuestion.builder()
                                                .question("¿Las próximas auditorías están programadas con fecha y auditor asignado?")
                                                .baseCategory(categories.get(21))
                                                .build(),
                                BaseQuestion.builder()
                                                .question("¿Se audita el área completa según el mapa 5S de la planta?")
                                                .baseCategory(categories.get(21))
                                                .build(),
                                BaseQuestion.builder()
                                                .question("¿El área auditada está claramente definida conforme al mapeo global de la planta?")
                                                .baseCategory(categories.get(21))
                                                .build(),
                                BaseQuestion.builder()
                                                .question("¿Las acciones definidas en la última auditoría han sido implementadas y cerradas?")
                                                .baseCategory(categories.get(21))
                                                .build(),

                                // Categoría 23: Entrenamientos 5S (S5)
                                BaseQuestion.builder()
                                                .question("¿Todo el personal ha recibido entrenamiento actualizado en 5S?")
                                                .baseCategory(categories.get(22))
                                                .build(),
                                BaseQuestion.builder()
                                                .question("¿Cada miembro del equipo participa activamente en acciones y actividades 5S?")
                                                .baseCategory(categories.get(22))
                                                .build(),
                                BaseQuestion.builder()
                                                .question("¿Existe un programa de capacitación continua en 5S para nuevos empleados?")
                                                .baseCategory(categories.get(22))
                                                .build(),
                                BaseQuestion.builder()
                                                .question("¿Se reconoce y premia la participación destacada en actividades 5S?")
                                                .baseCategory(categories.get(22))
                                                .build(),

                                // Categoría 24: Ideas mejora (S5)
                                BaseQuestion.builder()
                                                .question("¿Se registran y evalúan ideas de mejora relacionadas con 5S?")
                                                .baseCategory(categories.get(23))
                                                .build(),
                                BaseQuestion.builder()
                                                .question("¿Se utiliza metodología Quick Kaizen para implementar mejoras?")
                                                .baseCategory(categories.get(23))
                                                .build(),
                                BaseQuestion.builder()
                                                .question("¿Existe un sistema para que cualquier empleado pueda proponer mejoras?")
                                                .baseCategory(categories.get(23))
                                                .build(),
                                BaseQuestion.builder()
                                                .question("¿Las mejoras implementadas son comunicadas y celebradas?")
                                                .baseCategory(categories.get(23))
                                                .build(),

                                // Categoría 25: Indicadores desempeño (S5)
                                BaseQuestion.builder()
                                                .question("¿Existen indicadores claros de performance 5S y se comunican regularmente?")
                                                .baseCategory(categories.get(24))
                                                .build(),
                                BaseQuestion.builder()
                                                .question("¿Los indicadores de seguridad están vinculados con las actividades 5S?")
                                                .baseCategory(categories.get(24))
                                                .build(),
                                BaseQuestion.builder()
                                                .question("¿Los indicadores de calidad reflejan el impacto de la implementación 5S?")
                                                .baseCategory(categories.get(24))
                                                .build(),
                                BaseQuestion.builder()
                                                .question("¿Los indicadores operativos de desempeño muestran mejoras por 5S?")
                                                .baseCategory(categories.get(24))
                                                .build(),
                                BaseQuestion.builder()
                                                .question("¿Se realiza seguimiento visual del plan de acción y su evolución?")
                                                .baseCategory(categories.get(24))
                                                .build(),

                                // Categoría 26: Estándares 5S (S5)
                                BaseQuestion.builder()
                                                .question("¿El estándar 5S se aplica consistentemente con documentación visual?")
                                                .baseCategory(categories.get(25))
                                                .build(),
                                BaseQuestion.builder()
                                                .question("¿Los check-lists de 5S están completos y actualizados?")
                                                .baseCategory(categories.get(25))
                                                .build(),
                                BaseQuestion.builder()
                                                .question("¿Los estándares 5S son revisados y mejorados continuamente?")
                                                .baseCategory(categories.get(25))
                                                .build(),
                                BaseQuestion.builder()
                                                .question("¿Los estándares 5S forman parte de la cultura organizacional?")
                                                .baseCategory(categories.get(25))
                                                .build());
        }
}