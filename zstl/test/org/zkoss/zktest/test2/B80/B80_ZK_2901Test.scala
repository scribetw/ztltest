package org.zkoss.zktest.test2.B80

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags

/**
  *
  * @author Christopher
  */
@Tags(tags = "B80-ZK-2901.zul")
class B80_ZK_2901Test extends ZTL4ScalaTestCase {

  @Test
  def testClick() = {
    runZTL(
      () => {
        val button = jq("button")
        // click button to start removing tree items
        click(button)
        // wait for at most 3 seconds, if longer, it is a bug (only IE)
        waitResponse(3000)
        waitResponse(1000)

        val itemText = jq(".z-treecell-content .z-label").eq(0).text()
        // check the content of the first item is "1490"
        verifyEquals("expecting 1490, got: " + itemText, "1490", itemText)
      })
  }
}