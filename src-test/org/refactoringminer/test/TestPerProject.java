package org.refactoringminer.test;

import com.intellij.testFramework.fixtures.LightJavaCodeInsightFixtureTestCase;
import org.junit.Test;
import org.refactoringminer.rm1.GitHistoryRefactoringMinerImpl;

import java.util.List;

public class TestPerProject extends LightJavaCodeInsightFixtureTestCase {

    private static final String REPOS = "tmp1";
    private List<RefactoringPopulator.Root> roots;

    protected void setUp() throws Exception {
        super.setUp();
        this.roots = RefactoringPopulator.getFSERefactorings(RefactoringPopulator.Refactorings.All.getValue());
    }

    private void processRepositoryCommits(String gitURL, int expectedTPs, int expectedFPs, int expectedFNs) throws Exception {
        TestBuilder test = new TestBuilder(new GitHistoryRefactoringMinerImpl(), REPOS, RefactoringPopulator.Refactorings.All.getValue());
        for (RefactoringPopulator.Root root : roots) {
            if (gitURL.equals(root.repository))
                test.project(root.repository, "master").atCommit(root.sha1)
                        .containsOnly(RefactoringPopulator.extractRefactorings(root.refactorings));
        }
        test.assertExpectations(getProject(), expectedTPs, expectedFPs, expectedFNs, false);
    }

    @Test
    public void testProjects() throws Exception {
        processRepositoryCommits("https://github.com/apache/drill.git", 315, 0, 12);
        processRepositoryCommits("https://github.com/ReactiveX/RxJava.git", 15, 0, 0);
        processRepositoryCommits("https://github.com/CyanogenMod/android_frameworks_base.git", 54, 0, 1);
        processRepositoryCommits("https://github.com/real-logic/Aeron.git", 33, 0, 1);
        processRepositoryCommits("https://github.com/gradle/gradle.git", 141, 0, 4);
        processRepositoryCommits("https://github.com/geometer/FBReaderJ.git", 4, 0, 0);
        processRepositoryCommits("https://github.com/spring-projects/spring-data-neo4j.git", 108, 0, 2);
        processRepositoryCommits("https://github.com/wildfly/wildfly.git", 174, 0, 2);
        processRepositoryCommits("https://github.com/fabric8io/fabric8.git", 22, 0, 0);
        processRepositoryCommits("https://github.com/joel-costigliola/assertj-core.git", 100, 0, 1);
        processRepositoryCommits("https://github.com/structr/structr.git", 8, 0, 0);
        processRepositoryCommits("https://github.com/ignatov/intellij-erlang.git", 51, 0, 0);
        processRepositoryCommits("https://github.com/geoserver/geoserver.git", 83, 0, 4);
        processRepositoryCommits("https://github.com/BuildCraft/BuildCraft.git", 37, 1, 4);
        processRepositoryCommits("https://github.com/HubSpot/Singularity.git", 6, 0, 0);
        processRepositoryCommits("https://github.com/katzer/cordova-plugin-local-notifications.git", 63, 0, 2);
        processRepositoryCommits("https://github.com/FasterXML/jackson-databind.git", 26, 0, 0);
        processRepositoryCommits("https://github.com/aws/aws-sdk-java.git", 591, 0, 2);
        processRepositoryCommits("https://github.com/linkedin/rest.li.git", 184, 0, 5);
        processRepositoryCommits("https://github.com/open-keychain/open-keychain.git", 22, 0, 0);
        processRepositoryCommits("https://github.com/baasbox/baasbox.git", 1, 0, 0);
        processRepositoryCommits("https://github.com/phishman3579/java-algorithms-implementation.git", 437, 0, 0);
        processRepositoryCommits("https://github.com/square/wire.git", 46, 0, 2);
        processRepositoryCommits("https://github.com/abarisain/dmix.git", 3, 0, 0);
        processRepositoryCommits("https://github.com/netty/netty.git", 148, 1, 8);
        processRepositoryCommits("https://github.com/HdrHistogram/HdrHistogram.git", 2, 0, 0);
        processRepositoryCommits("https://github.com/grails/grails-core.git", 3, 0, 0);
        processRepositoryCommits("https://github.com/cwensel/cascading.git", 13, 0, 5);
        processRepositoryCommits("https://github.com/JetBrains/intellij-plugins.git", 4, 0, 0);
        processRepositoryCommits("https://github.com/dropwizard/metrics.git", 17, 0, 0);
        processRepositoryCommits("https://github.com/google/guava.git", 9, 0, 0);
        processRepositoryCommits("https://github.com/apache/giraph.git", 46, 3, 0);
        processRepositoryCommits("https://github.com/siacs/Conversations.git", 11, 0, 6);
        processRepositoryCommits("https://github.com/Netflix/genie.git", 8, 0, 0);
        processRepositoryCommits("https://github.com/eclipse/vert.x.git", 38, 0, 15);
        processRepositoryCommits("https://github.com/Netflix/eureka.git", 73, 0, 0);
        processRepositoryCommits("https://github.com/scobal/seyren.git", 4, 0, 1);
        processRepositoryCommits("https://github.com/wicketstuff/core.git", 1, 0, 0);
        processRepositoryCommits("https://github.com/spring-projects/spring-integration.git", 29, 0, 0);
        processRepositoryCommits("https://github.com/orfjackal/retrolambda.git", 3, 0, 0);
        processRepositoryCommits("https://github.com/tomahawk-player/tomahawk-android.git", 49, 0, 0);
        processRepositoryCommits("https://github.com/raphw/byte-buddy.git", 64, 0, 1);
        processRepositoryCommits("https://github.com/liferay/liferay-plugins.git", 12, 0, 0);
        processRepositoryCommits("https://github.com/jenkinsci/workflow-plugin.git", 10, 0, 0);
        processRepositoryCommits("https://github.com/gwtproject/gwt.git", 20, 0, 1);
        processRepositoryCommits("https://github.com/google/truth.git", 25, 0, 1);
        processRepositoryCommits("https://github.com/antlr/antlr4.git", 37, 0, 0);
        processRepositoryCommits("https://github.com/koush/AndroidAsync.git", 4, 0, 0);
        processRepositoryCommits("https://github.com/thymeleaf/thymeleaf.git", 4, 0, 0);
        processRepositoryCommits("https://github.com/PhilJay/MPAndroidChart.git", 10, 0, 0);
        processRepositoryCommits("https://github.com/spring-projects/spring-boot.git", 96, 0, 4);
        processRepositoryCommits("https://github.com/brettwooldridge/HikariCP.git", 8, 0, 0);
        processRepositoryCommits("https://github.com/eucalyptus/eucalyptus.git", 42, 0, 1);
        processRepositoryCommits("https://github.com/dreamhead/moco.git", 2, 0, 0);
        processRepositoryCommits("https://github.com/neo4j/neo4j.git", 848, 4, 37);
        processRepositoryCommits("https://github.com/skylot/jadx.git", 29, 1, 0);
        processRepositoryCommits("https://github.com/vaadin/vaadin.git", 3, 0, 0);
        processRepositoryCommits("https://github.com/restlet/restlet-framework-java.git", 5, 0, 0);
        processRepositoryCommits("https://github.com/redsolution/xabber-android.git", 2, 0, 0);
        processRepositoryCommits("https://github.com/codinguser/gnucash-android.git", 4, 0, 0);
        processRepositoryCommits("https://github.com/spring-projects/spring-data-jpa.git", 14, 0, 0);
        processRepositoryCommits("https://github.com/loopj/android-async-http.git", 1, 0, 0);
        processRepositoryCommits("https://github.com/datastax/java-driver.git", 30, 0, 3);
        processRepositoryCommits("https://github.com/SimonVT/schematic.git", 2, 0, 0);
        processRepositoryCommits("https://github.com/jfinal/jfinal.git", 230, 0, 19);
        processRepositoryCommits("https://github.com/oblac/jodd.git", 3, 0, 0);
        processRepositoryCommits("https://github.com/realm/realm-java.git", 14, 0, 0);
        processRepositoryCommits("https://github.com/bennidi/mbassador.git", 16, 0, 0);
        processRepositoryCommits("https://github.com/Athou/commafeed.git", 1, 0, 0);
        processRepositoryCommits("https://github.com/hazelcast/hazelcast.git", 449, 3, 11);
        processRepositoryCommits("https://github.com/cbeust/testng.git", 3, 0, 0);
        processRepositoryCommits("https://github.com/querydsl/querydsl.git", 17, 0, 0);
        processRepositoryCommits("https://github.com/mockito/mockito.git", 164, 0, 2);
        processRepositoryCommits("https://github.com/mrniko/redisson.git", 1, 0, 0);
        processRepositoryCommits("https://github.com/clojure/clojure.git", 10, 0, 1);
        processRepositoryCommits("https://github.com/belaban/JGroups.git", 7, 0, 0);
        processRepositoryCommits("https://github.com/WhisperSystems/Signal-Android.git", 67, 0, 3);
        processRepositoryCommits("https://github.com/Activiti/Activiti.git", 16, 0, 0);
        processRepositoryCommits("https://github.com/kuujo/copycat.git", 9, 0, 0);
        processRepositoryCommits("https://github.com/jankotek/MapDB.git", 12, 0, 1);
        processRepositoryCommits("https://github.com/undertow-io/undertow.git", 80, 0, 2);
        processRepositoryCommits("https://github.com/jberkel/sms-backup-plus.git", 1, 0, 0);
        processRepositoryCommits("https://github.com/apache/tomcat.git", 17, 0, 0);
        processRepositoryCommits("https://github.com/facebook/buck.git", 178, 0, 7);
        processRepositoryCommits("https://github.com/jayway/rest-assured.git", 2, 0, 0);
        processRepositoryCommits("https://github.com/graphhopper/graphhopper.git", 393, 2, 7);
        processRepositoryCommits("https://github.com/xetorthio/jedis.git", 33, 0, 0);
        processRepositoryCommits("https://github.com/eclipse/jetty.project.git", 12, 0, 4);
        processRepositoryCommits("https://github.com/droolsjbpm/jbpm.git", 150, 0, 4);
        processRepositoryCommits("https://github.com/jOOQ/jOOQ.git", 10, 0, 0);
        processRepositoryCommits("https://github.com/AsyncHttpClient/async-http-client.git", 2, 0, 0);
        processRepositoryCommits("https://github.com/jeeeyul/eclipse-themes.git", 3, 0, 0);
        processRepositoryCommits("https://github.com/JetBrains/MPS.git", 16, 0, 0);
        processRepositoryCommits("https://github.com/codefollower/Lealone.git", 11, 0, 0);
        processRepositoryCommits("https://github.com/AdoptOpenJDK/jitwatch.git", 23, 0, 1);
        processRepositoryCommits("https://github.com/liferay/liferay-portal.git", 3, 0, 0);
        processRepositoryCommits("https://github.com/square/mortar.git", 6, 0, 0);
        processRepositoryCommits("https://github.com/infinispan/infinispan.git", 489, 3, 23);
        processRepositoryCommits("https://github.com/crashub/crash.git", 2, 0, 0);
        processRepositoryCommits("https://github.com/glyptodon/guacamole-client.git", 14, 0, 0);
        processRepositoryCommits("https://github.com/github/android.git", 305, 0, 0);
        processRepositoryCommits("https://github.com/square/javapoet.git", 26, 0, 1);
        processRepositoryCommits("https://github.com/elastic/elasticsearch.git", 56, 0, 1);
        processRepositoryCommits("https://github.com/hierynomus/sshj.git", 3, 0, 0);
        processRepositoryCommits("https://github.com/rackerlabs/blueflood.git", 4, 0, 1);
        processRepositoryCommits("https://github.com/jersey/jersey.git", 181, 0, 1);
        processRepositoryCommits("https://github.com/Alluxio/alluxio.git", 36, 0, 1);
        processRepositoryCommits("https://github.com/spring-projects/spring-data-rest.git", 2, 0, 0);
        processRepositoryCommits("https://github.com/NLPchina/ansj_seg.git", 140, 0, 4);
        processRepositoryCommits("https://github.com/apache/camel.git", 12, 0, 0);
        processRepositoryCommits("https://github.com/droolsjbpm/drools.git", 124, 0, 2);
        processRepositoryCommits("https://github.com/robovm/robovm.git", 483, 0, 2);
        processRepositoryCommits("https://github.com/bitcoinj/bitcoinj.git", 134, 0, 5);
        processRepositoryCommits("https://github.com/facebook/presto.git", 305, 0, 0);
        processRepositoryCommits("https://github.com/deeplearning4j/deeplearning4j.git", 13, 0, 1);
        processRepositoryCommits("https://github.com/crate/crate.git", 167, 0, 1);
        processRepositoryCommits("https://github.com/libgdx/libgdx.git", 2, 0, 0);
        processRepositoryCommits("https://github.com/hibernate/hibernate-orm.git", 99, 0, 0);
        processRepositoryCommits("https://github.com/Netflix/zuul.git", 6, 1, 0);
        processRepositoryCommits("https://github.com/ratpack/ratpack.git", 4, 0, 0);
        processRepositoryCommits("https://github.com/brianfrankcooper/YCSB.git", 3, 0, 0);
        processRepositoryCommits("https://github.com/QuantumBadger/RedReader.git", 12, 0, 0);
        processRepositoryCommits("https://github.com/apache/cassandra.git", 285, 4, 4);
        processRepositoryCommits("https://github.com/addthis/hydra.git", 134, 0, 0);
        processRepositoryCommits("https://github.com/apache/pig.git", 7, 0, 1);
        processRepositoryCommits("https://github.com/apache/hive.git", 67, 0, 3);
        processRepositoryCommits("https://github.com/google/closure-compiler.git", 62, 0, 2);
        processRepositoryCommits("https://github.com/go-lang-plugin-org/go-lang-idea-plugin.git", 7, 0, 0);
        processRepositoryCommits("https://github.com/spring-projects/spring-framework.git", 79, 0, 3);
        processRepositoryCommits("https://github.com/greenrobot/greenDAO.git", 1, 0, 0);
        processRepositoryCommits("https://github.com/springfox/springfox.git", 5, 0, 0);
        processRepositoryCommits("https://github.com/alibaba/druid.git", 3, 0, 0);
        processRepositoryCommits("https://github.com/JoanZapata/android-iconify.git", 12, 0, 0);
        processRepositoryCommits("https://github.com/processing/processing.git", 19, 0, 1);
        processRepositoryCommits("https://github.com/spring-projects/spring-roo.git", 4, 0, 0);
        processRepositoryCommits("https://github.com/cgeo/cgeo.git", 10, 0, 0);
        processRepositoryCommits("https://github.com/plutext/docx4j.git", 226, 0, 0);
        processRepositoryCommits("https://github.com/checkstyle/checkstyle.git", 89, 0, 0);
        processRepositoryCommits("https://github.com/k9mail/k-9.git", 31, 0, 0);
        processRepositoryCommits("https://github.com/RoboBinding/RoboBinding.git", 10, 0, 0);
        processRepositoryCommits("https://github.com/selendroid/selendroid.git", 1, 0, 0);
        processRepositoryCommits("https://github.com/spring-projects/spring-data-mongodb.git", 1, 0, 0);
        processRepositoryCommits("https://github.com/google/auto.git", 7, 0, 0);
        processRepositoryCommits("https://github.com/Netflix/feign.git", 59, 0, 1);
        processRepositoryCommits("https://github.com/apache/zookeeper.git", 98, 0, 4);
        processRepositoryCommits("https://github.com/jMonkeyEngine/jmonkeyengine.git", 7, 0, 0);
        processRepositoryCommits("https://github.com/jboss-developer/jboss-eap-quickstarts.git", 3, 0, 0);
        processRepositoryCommits("https://github.com/AntennaPod/AntennaPod.git", 1, 0, 0);
        processRepositoryCommits("https://github.com/MovingBlocks/Terasology.git", 49, 0, 4);
        processRepositoryCommits("https://github.com/GoClipse/goclipse.git", 10, 0, 0);
        processRepositoryCommits("https://github.com/google/j2objc.git", 10, 0, 0);
        processRepositoryCommits("https://github.com/SonarSource/sonarqube.git", 98, 0, 6);
        processRepositoryCommits("https://github.com/Atmosphere/atmosphere.git", 4, 0, 0);
        processRepositoryCommits("https://github.com/slapperwan/gh4a.git", 16, 0, 0);
        processRepositoryCommits("https://github.com/square/okhttp.git", 190, 0, 0);
        processRepositoryCommits("https://github.com/opentripplanner/OpenTripPlanner.git", 28, 0, 0);
        processRepositoryCommits("https://github.com/facebook/facebook-android-sdk.git", 61, 0, 1);
        processRepositoryCommits("https://github.com/bumptech/glide.git", 2, 0, 0);
        processRepositoryCommits("https://github.com/languagetool-org/languagetool.git", 61, 0, 0);
        processRepositoryCommits("https://github.com/spring-projects/spring-hateoas.git", 4, 0, 0);
        processRepositoryCommits("https://github.com/rstudio/rstudio.git", 24, 0, 7);
        processRepositoryCommits("https://github.com/puniverse/quasar.git", 17, 0, 1);
        processRepositoryCommits("https://github.com/Jasig/cas.git", 4, 0, 0);
        processRepositoryCommits("https://github.com/cucumber/cucumber-jvm.git", 6, 0, 0);
        processRepositoryCommits("https://github.com/JetBrains/intellij-community.git", 199, 0, 6);
        processRepositoryCommits("https://github.com/orientechnologies/orientdb.git", 62, 0, 1);
        processRepositoryCommits("https://github.com/spotify/helios.git", 24, 0, 0);
        processRepositoryCommits("https://github.com/SlimeKnights/TinkersConstruct.git", 5, 0, 3);
        processRepositoryCommits("https://github.com/Graylog2/graylog2-server.git", 65, 0, 2);
        processRepositoryCommits("https://github.com/SecUpwN/Android-IMSI-Catcher-Detector.git", 7, 0, 0);
        processRepositoryCommits("https://github.com/jline/jline2.git", 22, 0, 0);
        processRepositoryCommits("https://github.com/killbill/killbill.git", 29, 0, 0);
        processRepositoryCommits("https://github.com/VoltDB/voltdb.git", 109, 0, 1);
        processRepositoryCommits("https://github.com/mongodb/morphia.git", 2, 0, 0);
        processRepositoryCommits("https://github.com/reactor/reactor.git", 11, 0, 0);
        processRepositoryCommits("https://github.com/zeromq/jeromq.git", 4, 0, 0);
        processRepositoryCommits("https://github.com/mongodb/mongo-java-driver.git", 1, 0, 0);
        processRepositoryCommits("https://github.com/osmandapp/Osmand.git", 10, 0, 0);
        processRepositoryCommits("https://github.com/openhab/openhab.git", 11, 0, 0);
        processRepositoryCommits("https://github.com/BroadleafCommerce/BroadleafCommerce.git", 32, 0, 4);
        processRepositoryCommits("https://github.com/nutzam/nutz.git", 5, 0, 0);
        processRepositoryCommits("https://github.com/spring-projects/spring-security.git", 24, 0, 2);
        processRepositoryCommits("https://github.com/novoda/android-demos.git", 4, 0, 0);
        processRepositoryCommits("https://github.com/wordpress-mobile/WordPress-Android.git", 34, 0, 1);
        processRepositoryCommits("https://github.com/junit-team/junit5.git", 19, 0, 0);
    }
}
