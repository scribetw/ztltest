package org.zkoss.zktest.test2.B70

import org.junit.Test
import org.openqa.selenium.Dimension
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags

@Tags(tags = "B70-ZK-2960.zul")
class B70_ZK_2960Test extends ZTL4ScalaTestCase {

  @Test
  def testClick() = {
    runZTL(
      () => {
        setWindowSize(getWindowWidth(), 800)
        sleep(500);
        val combobox = jq(".z-combobox").eq(8);
        val comboboxButton = combobox.find(".z-combobox-button");
        click(comboboxButton);
        waitResponse(true);
        val comboboxPopup = jq(".z-combobox-popup");
        val comboboxInput = combobox.find(".z-combobox-input");
        verifyTrue(comboboxPopup.offsetTop() < comboboxInput.offsetTop());
      })

  }
}