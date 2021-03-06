package org.zkoss.zktest.test2.B65

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags

@Tags(tags = "B65-ZK-1895.zul")
class B65_ZK_1895Test extends ZTL4ScalaTestCase {

  @Test
  def testClick() = {
    val zscript =
      """<?xml version="1.0" encoding="UTF-8"?>

<!--
B65-ZK-1895.zul

	Purpose:
		
	Description:
		
	History:
		Tue, Aug 27, 2013 11:22:27 AM, Created by jumperchen

Copyright (C) 2013 Potix Corporation. All Rights Reserved.

-->
<window border="none" width="100%" height="100%" id="test">
If you cannot see any content of the listbox, that's a bug.
    <zscript><![CDATA[
    void setModel(){
    	ListModelList model = new ListModelList();
    	for(int i=0;i<100;i++){
    		model.add("A"+i);
		}
    	listbox.setModel(model);
    }
    ]]></zscript>
    <listbox id="listbox" vflex="true" mold="paging"
    	autopaging="true" onCreate="setModel()">
    	<custom-attributes org.zkoss.zul.listbox.rod="true"/>
    	<listhead>
    		<listheader sort="auto">Title</listheader>
    	</listhead>
    	<template name="model">
    		<listitem>
    			<listcell label="${each}" />
    		</listitem>
    	</template>
    </listbox>
</window>"""
    runZTL(zscript,
      () => {

        verifyTrue("you should see the content of the listbox", jq(".z-listitem").exists)
      })

  }
}