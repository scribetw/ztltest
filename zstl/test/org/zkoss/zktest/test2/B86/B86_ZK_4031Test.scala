package org.zkoss.zktest.test2.B86

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags

/**
  * @author rudyhuang
  */
@Tags(tags = "B86-ZK-4031.zul")
class B86_ZK_4031Test extends ZTL4ScalaTestCase {
  @Test
  def test(): Unit = {
    runZTL(() => {
      verifyFalse(jq("#zk_log").exists())
      verifyEquals(3, jq("tr").length())
      verifyEquals(3, jq("option").length())
    })
  }
}
