import org.jsoup.Jsoup

import scala.jdk.CollectionConverters.CollectionHasAsScala

object JsoupScraper extends App {
  val doc = Jsoup.connect("http://en.wikipedia.org/").get()
  val title = doc.title()
  val inTheNews = doc.select("#mp-itn b a") // like CSS selctor id -> bold -> anchor tag
  val onThisDay = doc.select("#mp-otd b a")
  val didYouKnow = doc.select("#mp-dyk b a")

  val otds = for (otd <- onThisDay.asScala) yield (otd.attr("title"),otd.attr("href"))
  val headers = for (otd <- onThisDay.asScala) yield otd.text

  println(headers)

}
