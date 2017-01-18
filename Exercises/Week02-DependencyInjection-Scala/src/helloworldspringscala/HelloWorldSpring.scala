package helloworldspringscala

import java.io.FileInputStream
import java.util.Properties

import org.springframework.beans.factory.BeanFactory
import org.springframework.beans.factory.support.{DefaultListableBeanFactory, PropertiesBeanDefinitionReader}

object HelloWorldSpring {
  @throws(classOf[Exception])
  def main(args: Array[String]) {
    val factory: BeanFactory = getBeanFactory
    val mr: MessageRenderer = factory.getBean("renderer").asInstanceOf[MessageRenderer]
    val mp: MessageProvider = factory.getBean("provider").asInstanceOf[MessageProvider]
    mr.setMessageProvider(mp)
    mr.render
  }

  @throws(classOf[Exception])
  private def getBeanFactory: BeanFactory = {
    val factory: DefaultListableBeanFactory = new DefaultListableBeanFactory
    val rdr: PropertiesBeanDefinitionReader = new PropertiesBeanDefinitionReader(factory)
    val props: Properties = new Properties
    props.load(new FileInputStream("/Users/nathanhanak/GithubRepos/SDP_Portfolio_Nhanak/Exercises/Week02-DependencyInjection-Scala/src/helloworldspringscala/bean.properties"))
    rdr.registerBeanDefinitions(props)
    return factory
  }
}