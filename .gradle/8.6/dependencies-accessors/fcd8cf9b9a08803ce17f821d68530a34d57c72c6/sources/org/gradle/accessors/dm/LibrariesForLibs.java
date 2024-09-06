package org.gradle.accessors.dm;

import org.gradle.api.NonNullApi;
import org.gradle.api.artifacts.MinimalExternalModuleDependency;
import org.gradle.plugin.use.PluginDependency;
import org.gradle.api.artifacts.ExternalModuleDependencyBundle;
import org.gradle.api.artifacts.MutableVersionConstraint;
import org.gradle.api.provider.Provider;
import org.gradle.api.model.ObjectFactory;
import org.gradle.api.provider.ProviderFactory;
import org.gradle.api.internal.catalog.AbstractExternalDependencyFactory;
import org.gradle.api.internal.catalog.DefaultVersionCatalog;
import java.util.Map;
import org.gradle.api.internal.attributes.ImmutableAttributesFactory;
import org.gradle.api.internal.artifacts.dsl.CapabilityNotationParser;
import javax.inject.Inject;

/**
 * A catalog of dependencies accessible via the {@code libs} extension.
 */
@NonNullApi
public class LibrariesForLibs extends AbstractExternalDependencyFactory {

    private final AbstractExternalDependencyFactory owner = this;
    private final AsmLibraryAccessors laccForAsmLibraryAccessors = new AsmLibraryAccessors(owner);
    private final GuiceLibraryAccessors laccForGuiceLibraryAccessors = new GuiceLibraryAccessors(owner);
    private final Log4jLibraryAccessors laccForLog4jLibraryAccessors = new Log4jLibraryAccessors(owner);
    private final VersionAccessors vaccForVersionAccessors = new VersionAccessors(providers, config);
    private final BundleAccessors baccForBundleAccessors = new BundleAccessors(objects, providers, config, attributesFactory, capabilityNotationParser);
    private final PluginAccessors paccForPluginAccessors = new PluginAccessors(providers, config);

    @Inject
    public LibrariesForLibs(DefaultVersionCatalog config, ProviderFactory providers, ObjectFactory objects, ImmutableAttributesFactory attributesFactory, CapabilityNotationParser capabilityNotationParser) {
        super(config, providers, objects, attributesFactory, capabilityNotationParser);
    }

    /**
     * Group of libraries at <b>asm</b>
     */
    public AsmLibraryAccessors getAsm() {
        return laccForAsmLibraryAccessors;
    }

    /**
     * Group of libraries at <b>guice</b>
     */
    public GuiceLibraryAccessors getGuice() {
        return laccForGuiceLibraryAccessors;
    }

    /**
     * Group of libraries at <b>log4j</b>
     */
    public Log4jLibraryAccessors getLog4j() {
        return laccForLog4jLibraryAccessors;
    }

    /**
     * Group of versions at <b>versions</b>
     */
    public VersionAccessors getVersions() {
        return vaccForVersionAccessors;
    }

    /**
     * Group of bundles at <b>bundles</b>
     */
    public BundleAccessors getBundles() {
        return baccForBundleAccessors;
    }

    /**
     * Group of plugins at <b>plugins</b>
     */
    public PluginAccessors getPlugins() {
        return paccForPluginAccessors;
    }

    public static class AsmLibraryAccessors extends SubDependencyFactory implements DependencyNotationSupplier {

        public AsmLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>asm</b> with <b>org.ow2.asm:asm</b> coordinates and
         * with version reference <b>asm</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> asProvider() {
            return create("asm");
        }

        /**
         * Dependency provider for <b>analysis</b> with <b>org.ow2.asm:asm-analysis</b> coordinates and
         * with version reference <b>asm</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getAnalysis() {
            return create("asm.analysis");
        }

        /**
         * Dependency provider for <b>commons</b> with <b>org.ow2.asm:asm-commons</b> coordinates and
         * with version reference <b>asm</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getCommons() {
            return create("asm.commons");
        }

        /**
         * Dependency provider for <b>tree</b> with <b>org.ow2.asm:asm-tree</b> coordinates and
         * with version reference <b>asm</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getTree() {
            return create("asm.tree");
        }

        /**
         * Dependency provider for <b>util</b> with <b>org.ow2.asm:asm-util</b> coordinates and
         * with version reference <b>asm</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getUtil() {
            return create("asm.util");
        }

    }

    public static class GuiceLibraryAccessors extends SubDependencyFactory implements DependencyNotationSupplier {

        public GuiceLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>guice</b> with <b>com.google.inject:guice</b> coordinates and
         * with version reference <b>guice</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> asProvider() {
            return create("guice");
        }

        /**
         * Dependency provider for <b>assistedinject</b> with <b>com.google.inject.extensions:guice-assistedinject</b> coordinates and
         * with version reference <b>guice</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getAssistedinject() {
            return create("guice.assistedinject");
        }

        /**
         * Dependency provider for <b>servlet</b> with <b>com.google.inject.extensions:guice-servlet</b> coordinates and
         * with version reference <b>guice</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getServlet() {
            return create("guice.servlet");
        }

    }

    public static class Log4jLibraryAccessors extends SubDependencyFactory {
        private final Log4jSlf4j2LibraryAccessors laccForLog4jSlf4j2LibraryAccessors = new Log4jSlf4j2LibraryAccessors(owner);

        public Log4jLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>core</b> with <b>org.apache.logging.log4j:log4j-core</b> coordinates and
         * with version reference <b>log4j</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getCore() {
            return create("log4j.core");
        }

        /**
         * Group of libraries at <b>log4j.slf4j2</b>
         */
        public Log4jSlf4j2LibraryAccessors getSlf4j2() {
            return laccForLog4jSlf4j2LibraryAccessors;
        }

    }

    public static class Log4jSlf4j2LibraryAccessors extends SubDependencyFactory {

        public Log4jSlf4j2LibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>impl</b> with <b>org.apache.logging.log4j:log4j-slf4j2-impl</b> coordinates and
         * with version reference <b>log4j</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getImpl() {
            return create("log4j.slf4j2.impl");
        }

    }

    public static class VersionAccessors extends VersionFactory  {

        public VersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Version alias <b>asm</b> with value <b>9.6</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getAsm() { return getVersion("asm"); }

        /**
         * Version alias <b>guice</b> with value <b>5.1.0</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getGuice() { return getVersion("guice"); }

        /**
         * Version alias <b>log4j</b> with value <b>2.23.1</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getLog4j() { return getVersion("log4j"); }

    }

    public static class BundleAccessors extends BundleFactory {

        public BundleAccessors(ObjectFactory objects, ProviderFactory providers, DefaultVersionCatalog config, ImmutableAttributesFactory attributesFactory, CapabilityNotationParser capabilityNotationParser) { super(objects, providers, config, attributesFactory, capabilityNotationParser); }

    }

    public static class PluginAccessors extends PluginFactory {

        public PluginAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

    }

}
