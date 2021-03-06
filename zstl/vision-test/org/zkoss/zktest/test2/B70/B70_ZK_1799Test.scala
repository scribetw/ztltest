package org.zkoss.zktest.test2.B70

import org.zkoss.ztl.annotation.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.junit.Test

@Tags(tags = "B70-ZK-1799.zul")
class B70_ZK_1799Test extends ZTL4ScalaTestCase {

@Test
def testClick() = {
  val zscript = """<?xml version="1.0" encoding="UTF-8"?>

<!--
B70-ZK-1799.zul

	Purpose:
		
	Description:
		
	History:
		Tue, Apr 01, 2014  2:15:54 PM, Created by jumperchen

Copyright (C)  Potix Corporation. All Rights Reserved.

-->
<zk>
	The following cases should display as its description.
	<vlayout>
		<hlayout>
			<vlayout>
				<label multiline="true">
				1. You should see all the text of the title with "Panel has an extremely long title" 
				and the arrow icon cannot be put at next line (should be the same line)
				</label>
				<panel hflex="min" border="normal" collapsible="true">
					<caption hflex="min" >
						Panel has an extremely long title.
					</caption>
					<panelchildren>My data.</panelchildren>
				</panel>
			</vlayout>
			<vlayout>
				<label multiline="true">
				2. You should see the title length is the same as "My data."(i.e. "Panel" only)
				</label>
				<panel hflex="min" border="normal" collapsible="true">
					<caption>
						Panel has an extremely long title.
					</caption>
					<panelchildren>My data.</panelchildren>
				</panel>
			</vlayout>
			<vlayout>
				<label multiline="true">
				3. The panel width should be 200px
				</label>
				<panel hflex="min" border="normal" collapsible="true">
					<caption width="188px">
						Panel has an extremely long title.
					</caption>
					<panelchildren>My data.</panelchildren>
				</panel>
			</vlayout>
			<vlayout>
				<label multiline="true">
				4. The panel width should be 300px
				</label>
				<panel hflex="min" border="normal" collapsible="true" closable="true">
					<caption width="200px">
						Panel has an extremely long title.
					</caption>
					<panelchildren><div  width="298px">My data.</div></panelchildren>
				</panel>
			</vlayout>
		</hlayout>
		<hlayout>
			<vlayout>
				<label multiline="true">
				1. You should see all the text of the title with "Window has an extremely long title" 
				and the arrow icon cannot be put at next line (should be the same line)
				</label>
				<window hflex="min" border="normal" closable="true">
					<caption hflex="min" >
						Window has an extremely long title.
					</caption>
					My data.
				</window>
			</vlayout>
			<vlayout>
				<label multiline="true">
				2. You should see the title length is the same as "My data."(i.e. "Window h" only)
				</label>
				<window hflex="min" border="normal" closable="true">
					<caption>
						Window has an extremely long title.
					</caption>
					My data.
				</window>
			</vlayout>
			<vlayout>
				<label multiline="true">
				3. The Window width should be 200px
				</label>
				<window hflex="min" border="normal" closable="true">
					<caption width="190px">
						Window has an extremely long title.
					</caption>
					My data.
				</window>
			</vlayout>
			<vlayout>
				<label multiline="true">
				4. The Window width should be 300px
				</label>
				<window hflex="min" border="normal" closable="true">
					<caption width="200px">
						Window has an extremely long title.
					</caption>
					<div width="280px">My data.</div>
				</window>
			</vlayout>
		</hlayout>
	</vlayout>
</zk>
"""  
  runZTL(zscript,
    () => {
      verifyImage()
    })
    
  }
}