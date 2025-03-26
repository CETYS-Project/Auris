package com.cetys.loading.service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cetys.loading.model.BaseCategory;
import com.cetys.loading.model.BaseQuestion;
import com.cetys.loading.repository.BaseQuestionRepository;

@Service
public class BaseQuestionService {

        @Autowired
        private BaseQuestionRepository baseQuestionRepository;

        public List<BaseQuestion> getAllBaseQuestions() {
                return baseQuestionRepository.findAll();
        }

        public BaseQuestion getBaseQuestionById(Long id) {
                Optional<BaseQuestion> baseQuestion = baseQuestionRepository.findById(id);
                return baseQuestion.orElse(null);
        }

        public List<BaseQuestion> findAllByBaseCategoryId(Long baseCategoryId) {
                return baseQuestionRepository.findAllByBaseCategoryId(baseCategoryId);
        }

        public BaseQuestion createBaseQuestion(BaseQuestion baseQuestion) {
                return baseQuestionRepository.save(baseQuestion);
        }

        public BaseQuestion updateBaseQuestion(Long id, BaseQuestion baseQuestionDetails) {
                Optional<BaseQuestion> baseQuestionOptional = baseQuestionRepository.findById(id);
                if (baseQuestionOptional.isPresent()) {
                        BaseQuestion baseQuestion = baseQuestionOptional.get();
                        baseQuestion.setBaseCategory(baseQuestionDetails.getBaseCategory());
                        baseQuestion.setQuestion(baseQuestionDetails.getQuestion());
                        return baseQuestionRepository.save(baseQuestion);
                } else {
                        return null;
                }
        }

        public void deleteBaseQuestion(Long id) {
                baseQuestionRepository.deleteById(id);
        }

        public static List<BaseQuestion> getDefaultBaseQuestions(List<BaseCategory> categories) {

                return Arrays.asList(
                                // Categoría 1: Materiales innecesarios (S1)
                                new BaseQuestion("¿Hay materias primas innecesarias o en exceso en el área?",
                                                categories.get(0)),
                                new BaseQuestion(
                                                "¿Existen productos terminados o inventario obsoleto o sin identificación?",
                                                categories.get(0)),
                                new BaseQuestion(
                                                "¿Los EPP están completos y en buen estado (sin elementos innecesarios)?",
                                                categories.get(0)),
                                new BaseQuestion(
                                                "¿Existe un sistema claro para identificar y gestionar scrap y residuos?",
                                                categories.get(0)),
                                new BaseQuestion(
                                                "¿Los materiales de uso diario y pallets están organizados y solo los necesarios?",
                                                categories.get(0)),

                                // Categoría 2: Herramientas innecesarias (S1)
                                new BaseQuestion("¿Existen herramientas innecesarias, duplicadas o en mal estado?",
                                                categories.get(1)),
                                new BaseQuestion(
                                                "¿Los accesorios en general están clasificados y solo los necesarios están en el área?",
                                                categories.get(1)),
                                new BaseQuestion(
                                                "¿Se ha identificado y retirado el material de limpieza roto u obsoleto?",
                                                categories.get(1)),
                                new BaseQuestion(
                                                "¿El mobiliario y equipos informáticos son los necesarios para las tareas del área?",
                                                categories.get(1)),

                                // Categoría 3: Máquinas o equipos innecesarios (S1)
                                new BaseQuestion(
                                                "¿Existen máquinas o partes de máquinas innecesarias u obsoletas en el área?",
                                                categories.get(2)),
                                new BaseQuestion(
                                                "¿Los equipos de transporte y manipulación (auto-elevadores, apiladores, zorras) son los necesarios?",
                                                categories.get(2)),

                                // Categoría 4: Documentos innecesarios (S1)
                                new BaseQuestion(
                                                "¿La documentación de seguridad está actualizada y sin versiones obsoletas?",
                                                categories.get(3)),
                                new BaseQuestion(
                                                "¿La documentación de calidad está vigente y sin duplicados innecesarios?",
                                                categories.get(3)),
                                new BaseQuestion("¿La documentación operativa está actualizada y solo la necesaria?",
                                                categories.get(3)),
                                new BaseQuestion(
                                                "¿Las órdenes de producción están organizadas y se eliminan las completadas/obsoletas?",
                                                categories.get(3)),

                                // Categoría 5: Etiquetaje (S1)
                                new BaseQuestion(
                                                "¿Existe un procedimiento claro de etiquetaje de 5S para items innecesarios?",
                                                categories.get(4)),
                                new BaseQuestion(
                                                "¿Existe un área designada y señalizada para materiales innecesarios (red tag area)?",
                                                categories.get(4)),
                                new BaseQuestion(
                                                "¿Se utiliza correctamente el sistema de etiquetado para identificar elementos a descartar?",
                                                categories.get(4)),

                                // Categoría 6: IDENTIFICACIÓN (S2)
                                new BaseQuestion(
                                                "¿Los productos peligrosos están claramente identificados con señalización adecuada?",
                                                categories.get(5)),
                                new BaseQuestion(
                                                "¿Las máquinas y equipos de apoyo están identificados con nombre/código visible?",
                                                categories.get(5)),
                                new BaseQuestion(
                                                "¿Las líneas de producción están identificadas con nombres o códigos estandarizados?",
                                                categories.get(5)),
                                new BaseQuestion(
                                                "¿Los silos y tuberías están identificados con contenido, dirección y riesgos?",
                                                categories.get(5)),
                                new BaseQuestion(
                                                "¿Cada estación de trabajo está identificada con nombre/función/responsable?",
                                                categories.get(5)),
                                new BaseQuestion(
                                                "¿Los escritorios y equipos informáticos están identificados por usuario/función?",
                                                categories.get(5)),
                                new BaseQuestion(
                                                "¿Los equipos de seguridad y EPP están identificados y localizados adecuadamente?",
                                                categories.get(5)),
                                new BaseQuestion(
                                                "¿Las herramientas y equipos de limpieza están identificados y en ubicaciones marcadas?",
                                                categories.get(5)),

                                // Categoría 7: ORGANIZACIÓN (S2)
                                new BaseQuestion(
                                                "¿Los accesorios y herramientas están organizados según frecuencia de uso?",
                                                categories.get(6)),
                                new BaseQuestion(
                                                "¿Los equipos de seguridad están organizados para fácil acceso en caso de emergencia?",
                                                categories.get(6)),
                                new BaseQuestion(
                                                "¿Las herramientas de limpieza y consumibles están organizadas por tipo y uso?",
                                                categories.get(6)),
                                new BaseQuestion(
                                                "¿El mobiliario está organizado de manera eficiente para optimizar el flujo de trabajo?",
                                                categories.get(6)),
                                new BaseQuestion(
                                                "¿Existe un lugar específico para cada elemento con indicación visual?",
                                                categories.get(6)),

                                // Categoría 8: DEMARCACIÓN (S2)
                                new BaseQuestion(
                                                "¿El área de acabado está claramente demarcada con líneas/señalización?",
                                                categories.get(7)),
                                new BaseQuestion("¿Las áreas de residuos están demarcadas por tipo de residuo?",
                                                categories.get(7)),
                                new BaseQuestion("¿Las áreas de suministros están demarcadas según tipo de material?",
                                                categories.get(7)),
                                new BaseQuestion("¿Las estaciones de trabajo tienen límites claramente marcados?",
                                                categories.get(7)),
                                new BaseQuestion(
                                                "¿Las áreas de productos peligrosos están demarcadas con señalización de riesgo?",
                                                categories.get(7)),
                                new BaseQuestion(
                                                "¿Las sendas peatonales están claramente marcadas y libres de obstáculos?",
                                                categories.get(7)),
                                new BaseQuestion(
                                                "¿Las áreas de máquinas y zonas de no acceso están correctamente señalizadas?",
                                                categories.get(7)),

                                // Categoría 9: Kanban (S2)
                                new BaseQuestion(
                                                "¿El sistema Kanban para productos terminados está implementado y respetado?",
                                                categories.get(8)),
                                new BaseQuestion("¿Existe un sistema visual para gestión de residuos/waste?",
                                                categories.get(8)),
                                new BaseQuestion(
                                                "¿El control visual de materia prima/suministros permite identificar niveles mínimos?",
                                                categories.get(8)),
                                new BaseQuestion(
                                                "¿Los elementos de seguridad tienen un sistema visual para control de stock/estado?",
                                                categories.get(8)),
                                new BaseQuestion("¿Los residuos están separados según tipo con identificación clara?",
                                                categories.get(8)),
                                new BaseQuestion(
                                                "¿Existe un sistema visual para control de elementos y herramientas de limpieza?",
                                                categories.get(8)),

                                // Categoría 10: Documentos necesarios (S2)
                                new BaseQuestion("¿Las órdenes de producción están visibles, accesibles y organizadas?",
                                                categories.get(9)),
                                new BaseQuestion(
                                                "¿La documentación de seguridad está disponible, visible y organizada?",
                                                categories.get(9)),
                                new BaseQuestion("¿La documentación de calidad está accesible donde se necesita?",
                                                categories.get(9)),
                                new BaseQuestion(
                                                "¿Los procedimientos operativos están organizados y fácilmente consultables?",
                                                categories.get(9)),
                                new BaseQuestion(
                                                "¿Existe un sistema de organización para documentos (físicos/digitales)?",
                                                categories.get(9)),

                                // Categoría 11: Herramientas de limpieza (S3)
                                new BaseQuestion(
                                                "¿Los productos de limpieza están disponibles, identificados y almacenados correctamente?",
                                                categories.get(10)),
                                new BaseQuestion(
                                                "¿Los materiales y equipos de limpieza están en buen estado y organizados?",
                                                categories.get(10)),
                                new BaseQuestion(
                                                "¿Existe un procedimiento de limpieza detallado para todas las áreas y equipos?",
                                                categories.get(10)),
                                new BaseQuestion(
                                                "¿Los procedimientos de limpieza incluyen frecuencia, responsable y método?",
                                                categories.get(10)),

                                // Categoría 12: Limpieza estaciones (S3)
                                new BaseQuestion(
                                                "¿Las máquinas y estaciones de trabajo están limpias y sin acumulación de residuos?",
                                                categories.get(11)),
                                new BaseQuestion("¿Las tuberías y bombas están limpias y sin fugas o derrames?",
                                                categories.get(11)),
                                new BaseQuestion("¿Los armarios y estanterías están limpios interna y externamente?",
                                                categories.get(11)),
                                new BaseQuestion("¿El área de segregación de residuos está limpia y organizada?",
                                                categories.get(11)),

                                // Categoría 13: Eliminación suciedad (S3)
                                new BaseQuestion(
                                                "¿Se identifican y abordan las fuentes de suciedad en máquinas y estaciones?",
                                                categories.get(12)),
                                new BaseQuestion(
                                                "¿Se realiza mantenimiento preventivo en tuberías y bombas para evitar fugas?",
                                                categories.get(12)),
                                new BaseQuestion(
                                                "¿Los armarios y estanterías tienen un sistema para prevenir acumulación de polvo?",
                                                categories.get(12)),
                                new BaseQuestion(
                                                "¿Existen medidas preventivas en el área de residuos para evitar contaminación?",
                                                categories.get(12)),
                                new BaseQuestion(
                                                "¿Las oficinas de producción y cabinas de control mantienen estándares de limpieza?",
                                                categories.get(12)),

                                // Categoría 14: Limpieza pisos (S3)
                                new BaseQuestion("¿Los pisos y corredores están limpios, secos y sin obstáculos?",
                                                categories.get(13)),
                                new BaseQuestion(
                                                "¿Las áreas de residuos tienen pisos limpios y sin contaminación cruzada?",
                                                categories.get(13)),
                                new BaseQuestion("¿Toda la iluminación funciona correctamente y está limpia?",
                                                categories.get(13)),
                                new BaseQuestion("¿Las paredes y techos están limpios y en buen estado?",
                                                categories.get(13)),
                                new BaseQuestion(
                                                "¿Existe un programa de limpieza para pisos con horarios establecidos?",
                                                categories.get(13)),

                                // Categoría 15: Comportamientos limpieza (S3)
                                new BaseQuestion(
                                                "¿Se cumple la rutina de limpieza diaria por parte de todo el personal?",
                                                categories.get(14)),
                                new BaseQuestion(
                                                "¿Los checklists de limpieza/gestión autónoma de máquinas y equipos están actualizados?",
                                                categories.get(14)),
                                new BaseQuestion(
                                                "¿Los checklists de limpieza de equipos de movimiento de materiales están actualizados?",
                                                categories.get(14)),
                                new BaseQuestion("¿Los uniformes y EPP se mantienen limpios y en buen estado?",
                                                categories.get(14)),
                                new BaseQuestion(
                                                "¿Existe cultura de 'limpiar mientras trabajas' en todos los empleados?",
                                                categories.get(14)),

                                // Categoría 16: Estándares visuales (S4)
                                new BaseQuestion(
                                                "¿Las tuberías están identificadas con código de colores según contenido/dirección?",
                                                categories.get(15)),
                                new BaseQuestion(
                                                "¿Las máquinas y equipos tienen controles visuales para identificar el estado normal?",
                                                categories.get(15)),
                                new BaseQuestion("¿Las herramientas tienen control visual para su ubicación y estado?",
                                                categories.get(15)),
                                new BaseQuestion(
                                                "¿Las áreas y puestos de trabajo tienen ayudas visuales para mantener el orden?",
                                                categories.get(15)),
                                new BaseQuestion(
                                                "¿Los escritorios y salas de reuniones tienen estándares visuales de organización?",
                                                categories.get(15)),

                                // Categoría 17: Estándares organización (S4)
                                new BaseQuestion(
                                                "¿Existen estándares visuales de limpieza con imágenes del 'antes y después'?",
                                                categories.get(16)),
                                new BaseQuestion("¿El estándar de descarte está documentado y visible para todos?",
                                                categories.get(16)),
                                new BaseQuestion("¿Los estándares de organización son conocidos y aplicados por todos?",
                                                categories.get(16)),
                                new BaseQuestion(
                                                "¿Existen auditorías periódicas para verificar cumplimiento de estándares?",
                                                categories.get(16)),

                                // Categoría 18: Procedimientos operativos (S4)
                                new BaseQuestion("¿Los estándares de salud y seguridad están documentados y visibles?",
                                                categories.get(17)),
                                new BaseQuestion("¿Los estándares operativos son claros, actualizados y accesibles?",
                                                categories.get(17)),
                                new BaseQuestion(
                                                "¿Los estándares de calidad están integrados en los procedimientos diarios?",
                                                categories.get(17)),
                                new BaseQuestion(
                                                "¿Existe un sistema para actualizar y comunicar cambios en procedimientos?",
                                                categories.get(17)),

                                // Categoría 19: Materiales consumo (S4)
                                new BaseQuestion(
                                                "¿Los materiales de consumo/productos tienen estándares de almacenamiento visibles?",
                                                categories.get(18)),
                                new BaseQuestion(
                                                "¿Las materias primas tienen estándares de manipulación y almacenamiento claros?",
                                                categories.get(18)),
                                new BaseQuestion("¿Existe control visual para niveles mínimos y máximos de inventario?",
                                                categories.get(18)),

                                // Categoría 20: Gestión 5S (S4)
                                new BaseQuestion(
                                                "¿Existen carteleras específicas de 5S para cada máquina y equipo crítico?",
                                                categories.get(19)),
                                new BaseQuestion("¿Hay una cartelera general de 5S para el área completa?",
                                                categories.get(19)),
                                new BaseQuestion(
                                                "¿El tablero de comunicación del área está actualizado con información relevante?",
                                                categories.get(19)),
                                new BaseQuestion(
                                                "¿El plan de acción de la auditoría se implementa dentro de los 10 días posteriores?",
                                                categories.get(19)),
                                new BaseQuestion(
                                                "¿El plan de acción de la última auditoría está publicado en las carteleras?",
                                                categories.get(19)),

                                // Categoría 21: Estándares 5S (S4)
                                new BaseQuestion(
                                                "¿El estándar 5S está definido con imágenes claras y descripciones detalladas?",
                                                categories.get(20)),
                                new BaseQuestion("¿Los checklist de 5S asociados al estándar están definidos y en uso?",
                                                categories.get(20)),
                                new BaseQuestion("¿Los estándares 5S son revisados y actualizados periódicamente?",
                                                categories.get(20)),

                                // Categoría 22: Programa 5S (S5)
                                new BaseQuestion(
                                                "¿Se realizan reuniones periódicas de 5S del área con reportes documentados?",
                                                categories.get(21)),
                                new BaseQuestion(
                                                "¿Las auditorías de 5S se realizan según cronograma y están disponibles en el área?",
                                                categories.get(21)),
                                new BaseQuestion(
                                                "¿Todos los auditores designados han cumplido con las últimas dos auditorías planificadas?",
                                                categories.get(21)),
                                new BaseQuestion(
                                                "¿Las próximas auditorías están programadas con fecha y auditor asignado?",
                                                categories.get(21)),
                                new BaseQuestion("¿Se audita el área completa según el mapa 5S de la planta?",
                                                categories.get(21)),
                                new BaseQuestion(
                                                "¿El área auditada está claramente definida conforme al mapeo global de la planta?",
                                                categories.get(21)),
                                new BaseQuestion(
                                                "¿Las acciones definidas en la última auditoría han sido implementadas y cerradas?",
                                                categories.get(21)),

                                // Categoría 23: Entrenamientos 5S (S5)
                                new BaseQuestion("¿Todo el personal ha recibido entrenamiento actualizado en 5S?",
                                                categories.get(22)),
                                new BaseQuestion(
                                                "¿Cada miembro del equipo participa activamente en acciones y actividades 5S?",
                                                categories.get(22)),
                                new BaseQuestion(
                                                "¿Existe un programa de capacitación continua en 5S para nuevos empleados?",
                                                categories.get(22)),
                                new BaseQuestion("¿Se reconoce y premia la participación destacada en actividades 5S?",
                                                categories.get(22)),

                                // Categoría 24: Ideas mejora (S5)
                                new BaseQuestion("¿Se registran y evalúan ideas de mejora relacionadas con 5S?",
                                                categories.get(23)),
                                new BaseQuestion("¿Se utiliza metodología Quick Kaizen para implementar mejoras?",
                                                categories.get(23)),
                                new BaseQuestion(
                                                "¿Existe un sistema para que cualquier empleado pueda proponer mejoras?",
                                                categories.get(23)),
                                new BaseQuestion("¿Las mejoras implementadas son comunicadas y celebradas?",
                                                categories.get(23)),

                                // Categoría 25: Indicadores desempeño (S5)
                                new BaseQuestion(
                                                "¿Existen indicadores claros de performance 5S y se comunican regularmente?",
                                                categories.get(24)),
                                new BaseQuestion(
                                                "¿Los indicadores de seguridad están vinculados con las actividades 5S?",
                                                categories.get(24)),
                                new BaseQuestion(
                                                "¿Los indicadores de calidad reflejan el impacto de la implementación 5S?",
                                                categories.get(24)),
                                new BaseQuestion("¿Los indicadores operativos de desempeño muestran mejoras por 5S?",
                                                categories.get(24)),
                                new BaseQuestion("¿Se realiza seguimiento visual del plan de acción y su evolución?",
                                                categories.get(24)),

                                // Categoría 26: Estándares 5S (S5)
                                new BaseQuestion("¿El estándar 5S se aplica consistentemente con documentación visual?",
                                                categories.get(25)),
                                new BaseQuestion("¿Los check-lists de 5S están completos y actualizados?",
                                                categories.get(25)),
                                new BaseQuestion("¿Los estándares 5S son revisados y mejorados continuamente?",
                                                categories.get(25)),
                                new BaseQuestion("¿Los estándares 5S forman parte de la cultura organizacional?",
                                                categories.get(25)));
        }
}