package com.cetys.loading.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.cetys.loading.enums.SCategory;
import com.cetys.loading.model.BaseCategory;

@Service
public class BaseCategoryService {

        public static List<BaseCategory> getDefaultBaseCategories() {
                // Categorias S1 (1-5)
                BaseCategory cat1 = BaseCategory.builder()
                                .name("Eliminación de materiales innecesarios")
                                .description("Elementos que no se utilizan en el área de trabajo y ocupan espacio innecesario.")
                                .sCategory(SCategory.S1)
                                .build();
                BaseCategory cat2 = BaseCategory.builder()
                                .name("Reducción de herramientas innecesarias")
                                .description("Herramientas que no son requeridas para las operaciones diarias y generan desorden.")
                                .sCategory(SCategory.S1)
                                .build();
                BaseCategory cat3 = BaseCategory.builder()
                                .name("Optimización de maquinaria y equipos")
                                .description("Equipos que no se usan frecuentemente y afectan la eficiencia del espacio.")
                                .sCategory(SCategory.S1)
                                .build();
                BaseCategory cat4 = BaseCategory.builder()
                                .name("Gestión de documentos y archivos")
                                .description("Papeles y archivos obsoletos o en desuso que generan desorden visual.")
                                .sCategory(SCategory.S1)
                                .build();
                BaseCategory cat5 = BaseCategory.builder()
                                .name("Etiquetado y clasificación")
                                .description("Identificación adecuada de materiales, herramientas y equipos para facilitar su uso y localización.")
                                .sCategory(SCategory.S1)
                                .build();

                // Categorías S2 (6-10)
                BaseCategory cat6 = BaseCategory.builder()
                                .name("Identificación visual en el entorno de trabajo")
                                .description("Marcado claro para mejorar la seguridad y eficiencia en el área de trabajo.")
                                .sCategory(SCategory.S2)
                                .build();
                BaseCategory cat7 = BaseCategory.builder()
                                .name("Organización eficiente de herramientas y materiales")
                                .description("Disposición eficiente de los elementos necesarios para facilitar el trabajo.")
                                .sCategory(SCategory.S2)
                                .build();
                BaseCategory cat8 = BaseCategory.builder()
                                .name("Demarcación de espacios y flujo de trabajo")
                                .description("Definir zonas de trabajo, seguridad y almacenamiento con señales visuales.")
                                .sCategory(SCategory.S2)
                                .build();
                BaseCategory cat9 = BaseCategory.builder()
                                .name("Gestión visual de inventarios (Kanban)")
                                .description("Sistema de gestión visual para el control eficiente del inventario.")
                                .sCategory(SCategory.S2)
                                .build();
                BaseCategory cat10 = BaseCategory.builder()
                                .name("Disponibilidad de documentación clave")
                                .description("Asegurar la disponibilidad de documentos relevantes en los lugares adecuados.")
                                .sCategory(SCategory.S2)
                                .build();

                // Categorías S3 (11-15)
                BaseCategory cat11 = BaseCategory.builder()
                                .name("Disponibilidad de herramientas y materiales de limpieza")
                                .description("Disponibilidad de herramientas y productos necesarios para mantener el área limpia.")
                                .sCategory(SCategory.S3)
                                .build();
                BaseCategory cat12 = BaseCategory.builder()
                                .name("Limpieza de estaciones de trabajo y equipos")
                                .description("Mantenimiento regular para evitar acumulación de suciedad y desgaste prematuro.")
                                .sCategory(SCategory.S3)
                                .build();
                BaseCategory cat13 = BaseCategory.builder()
                                .name("Prevención de fuentes de suciedad y contaminación")
                                .description("Prevención y eliminación de elementos que generan contaminación en el entorno laboral.")
                                .sCategory(SCategory.S3)
                                .build();
                BaseCategory cat14 = BaseCategory.builder()
                                .name("Mantenimiento de pisos y manejo de residuos")
                                .description("Mantenimiento de suelos limpios y manejo adecuado de desechos industriales.")
                                .sCategory(SCategory.S3)
                                .build();
                BaseCategory cat15 = BaseCategory.builder()
                                .name("Cultura de limpieza y orden")
                                .description("Fomentar hábitos de limpieza y orden en el personal.")
                                .sCategory(SCategory.S3)
                                .build();

                // Categorías S4 (16-21)
                BaseCategory cat16 = BaseCategory.builder()
                                .name("Estandarización visual y señalización")
                                .description("Uso de señales y etiquetas para mejorar la organización y seguridad.")
                                .sCategory(SCategory.S4)
                                .build();
                BaseCategory cat17 = BaseCategory.builder()
                                .name("Normas de organización y limpieza")
                                .description("Definir y aplicar normas para mantener el orden y la higiene.")
                                .sCategory(SCategory.S4)
                                .build();
                BaseCategory cat18 = BaseCategory.builder()
                                .name("Procedimientos operativos y estándares de seguridad")
                                .description("Normas y protocolos que garantizan un entorno de trabajo seguro y eficiente.")
                                .sCategory(SCategory.S4)
                                .build();
                BaseCategory cat19 = BaseCategory.builder()
                                .name("Gestión eficiente de materiales y productos")
                                .description("Control y manejo eficiente de insumos y productos en el área de trabajo.")
                                .sCategory(SCategory.S4)
                                .build();
                BaseCategory cat20 = BaseCategory.builder()
                                .name("Supervisión y mejora continua en 5S")
                                .description("Implementación y supervisión de la metodología 5S en la empresa.")
                                .sCategory(SCategory.S4)
                                .build();
                BaseCategory cat21 = BaseCategory.builder()
                                .name("Normas y estándares del sistema 5S")
                                .description("Definir y mantener las normas de 5S para una mejora continua.")
                                .sCategory(SCategory.S4)
                                .build();

                // Categorías S5 (22-26)
                BaseCategory cat22 = BaseCategory.builder()
                                .name("Compromiso organizacional con 5S")
                                .description("Implementación de 5S con apoyo de la dirección y un equipo responsable.")
                                .sCategory(SCategory.S5)
                                .build();
                BaseCategory cat23 = BaseCategory.builder()
                                .name("Formación y auditoría del sistema 5S")
                                .description("Capacitaciones y evaluaciones periódicas para asegurar el cumplimiento de 5S.")
                                .sCategory(SCategory.S5)
                                .build();
                BaseCategory cat24 = BaseCategory.builder()
                                .name("Fomento de ideas y proyectos de mejora")
                                .description("Fomentar la mejora continua mediante iniciativas y proyectos.")
                                .sCategory(SCategory.S5)
                                .build();
                BaseCategory cat25 = BaseCategory.builder()
                                .name("Monitoreo e indicadores de desempeño")
                                .description("Métricas y análisis para evaluar la efectividad del programa 5S.")
                                .sCategory(SCategory.S5)
                                .build();
                BaseCategory cat26 = BaseCategory.builder()
                                .name("Sostenibilidad y cumplimiento de estándares")
                                .description("Normas y directrices para asegurar la sostenibilidad del sistema 5S.")
                                .sCategory(SCategory.S5)
                                .build();

                return Arrays.asList(
                                cat1, cat2, cat3, cat4, cat5, cat6, cat7, cat8, cat9, cat10,
                                cat11, cat12, cat13, cat14, cat15, cat16, cat17, cat18, cat19, cat20,
                                cat21, cat22, cat23, cat24, cat25, cat26);
        }
}