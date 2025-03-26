package com.cetys.loading.service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cetys.loading.enums.SCategory;
import com.cetys.loading.model.BaseCategory;
import com.cetys.loading.repository.BaseCategoryRepository;

@Service
public class BaseCategoryService {

        @Autowired
        private BaseCategoryRepository baseCategoryRepository;

        public List<BaseCategory> getAllBaseCategories() {
                return baseCategoryRepository.findAll();
        }

        public List<BaseCategory> getAllBaseCategoriesBySubarea(Long subareaId) {
                return baseCategoryRepository.findAllBySubareaId(subareaId);
        }

        public BaseCategory getBaseCategoryById(Long id) {
                Optional<BaseCategory> baseCategory = baseCategoryRepository.findById(id);
                return baseCategory.orElse(null);
        }

        public BaseCategory createBaseCategory(BaseCategory baseCategory) {
                return baseCategoryRepository.save(baseCategory);
        }

        public BaseCategory updateBaseCategory(Long id, BaseCategory baseCategoryDetails) {
                Optional<BaseCategory> baseCategoryOptional = baseCategoryRepository.findById(id);
                if (baseCategoryOptional.isPresent()) {
                        BaseCategory baseCategory = baseCategoryOptional.get();
                        baseCategory.setSubarea(baseCategoryDetails.getSubarea());
                        baseCategory.setSCategory(baseCategoryDetails.getSCategory());
                        baseCategory.setName(baseCategoryDetails.getName());
                        baseCategory.setDescription(baseCategoryDetails.getDescription());
                        return baseCategoryRepository.save(baseCategory);
                } else {
                        return null;
                }
        }

        public void deleteBaseCategory(Long id) {
                baseCategoryRepository.deleteById(id);
        }

        public static List<BaseCategory> getDefaultBaseCategories() {
                // Categorias S1 (1-5)
                BaseCategory cat1 = new BaseCategory("Eliminación de materiales innecesarios",
                                "Elementos que no se utilizan en el área de trabajo y ocupan espacio innecesario.",
                                SCategory.S1);
                BaseCategory cat2 = new BaseCategory("Reducción de herramientas innecesarias",
                                "Herramientas que no son requeridas para las operaciones diarias y generan desorden.",
                                SCategory.S1);
                BaseCategory cat3 = new BaseCategory("Optimización de maquinaria y equipos",
                                "Equipos que no se usan frecuentemente y afectan la eficiencia del espacio.",
                                SCategory.S1);
                BaseCategory cat4 = new BaseCategory("Gestión de documentos y archivos",
                                "Papeles y archivos obsoletos o en desuso que generan desorden visual.", SCategory.S1);
                BaseCategory cat5 = new BaseCategory("Etiquetado y clasificación",
                                "Identificación adecuada de materiales, herramientas y equipos para facilitar su uso y localización.",
                                SCategory.S1);

                // Categorías S2 (6-10)
                BaseCategory cat6 = new BaseCategory("Identificación visual en el entorno de trabajo",
                                "Marcado claro para mejorar la seguridad y eficiencia en el área de trabajo.",
                                SCategory.S2);
                BaseCategory cat7 = new BaseCategory("Organización eficiente de herramientas y materiales",
                                "Disposición eficiente de los elementos necesarios para facilitar el trabajo.",
                                SCategory.S2);
                BaseCategory cat8 = new BaseCategory("Demarcación de espacios y flujo de trabajo",
                                "Definir zonas de trabajo, seguridad y almacenamiento con señales visuales.",
                                SCategory.S2);
                BaseCategory cat9 = new BaseCategory("Gestión visual de inventarios (Kanban)",
                                "Sistema de gestión visual para el control eficiente del inventario.", SCategory.S2);
                BaseCategory cat10 = new BaseCategory("Disponibilidad de documentación clave",
                                "Asegurar la disponibilidad de documentos relevantes en los lugares adecuados.",
                                SCategory.S2);

                // Categorías S3 (11-15)
                BaseCategory cat11 = new BaseCategory("Disponibilidad de herramientas y materiales de limpieza",
                                "Disponibilidad de herramientas y productos necesarios para mantener el área limpia.",
                                SCategory.S3);
                BaseCategory cat12 = new BaseCategory("Limpieza de estaciones de trabajo y equipos",
                                "Mantenimiento regular para evitar acumulación de suciedad y desgaste prematuro.",
                                SCategory.S3);
                BaseCategory cat13 = new BaseCategory("Prevención de fuentes de suciedad y contaminación",
                                "Prevención y eliminación de elementos que generan contaminación en el entorno laboral.",
                                SCategory.S3);
                BaseCategory cat14 = new BaseCategory("Mantenimiento de pisos y manejo de residuos",
                                "Mantenimiento de suelos limpios y manejo adecuado de desechos industriales.",
                                SCategory.S3);
                BaseCategory cat15 = new BaseCategory("Cultura de limpieza y orden",
                                "Fomentar hábitos de limpieza y orden en el personal.", SCategory.S3);

                // Categorías S4 (16-21)
                BaseCategory cat16 = new BaseCategory("Estandarización visual y señalización",
                                "Uso de señales y etiquetas para mejorar la organización y seguridad.", SCategory.S4);
                BaseCategory cat17 = new BaseCategory("Normas de organización y limpieza",
                                "Definir y aplicar normas para mantener el orden y la higiene.", SCategory.S4);
                BaseCategory cat18 = new BaseCategory("Procedimientos operativos y estándares de seguridad",
                                "Normas y protocolos que garantizan un entorno de trabajo seguro y eficiente.",
                                SCategory.S4);
                BaseCategory cat19 = new BaseCategory("Gestión eficiente de materiales y productos",
                                "Control y manejo eficiente de insumos y productos en el área de trabajo.",
                                SCategory.S4);
                BaseCategory cat20 = new BaseCategory("Supervisión y mejora continua en 5S",
                                "Implementación y supervisión de la metodología 5S en la empresa.", SCategory.S4);
                BaseCategory cat21 = new BaseCategory("Normas y estándares del sistema 5S",
                                "Definir y mantener las normas de 5S para una mejora continua.", SCategory.S4);

                // Categorías S5 (22-26)
                BaseCategory cat22 = new BaseCategory("Compromiso organizacional con 5S",
                                "Implementación de 5S con apoyo de la dirección y un equipo responsable.",
                                SCategory.S5);
                BaseCategory cat23 = new BaseCategory("Formación y auditoría del sistema 5S",
                                "Capacitaciones y evaluaciones periódicas para asegurar el cumplimiento de 5S.",
                                SCategory.S5);
                BaseCategory cat24 = new BaseCategory("Fomento de ideas y proyectos de mejora",
                                "Fomentar la mejora continua mediante iniciativas y proyectos.", SCategory.S5);
                BaseCategory cat25 = new BaseCategory("Monitoreo e indicadores de desempeño",
                                "Métricas y análisis para evaluar la efectividad del programa 5S.", SCategory.S5);
                BaseCategory cat26 = new BaseCategory("Sostenibilidad y cumplimiento de estándares",
                                "Normas y directrices para asegurar la sostenibilidad del sistema 5S.", SCategory.S5);

                return Arrays.asList(
                                cat1, cat2, cat3, cat4, cat5, cat6, cat7, cat8, cat9, cat10,
                                cat11, cat12, cat13, cat14, cat15, cat16, cat17, cat18, cat19, cat20,
                                cat21, cat22, cat23, cat24, cat25, cat26);
        }
}