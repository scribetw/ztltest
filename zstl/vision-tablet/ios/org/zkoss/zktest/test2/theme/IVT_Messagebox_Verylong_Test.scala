package org.zkoss.zktest.test2.theme

import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags

@Tags(tags = "IOS,VisionTest")
class IVT_Messagebox_Verylong_Test extends ZTL4ScalaTestCase {
	def testClick() = {
		val zscript = """
<zscript>
<![CDATA[
    import org.zkoss.zul.Messagebox;
    
	// Ulysses from Project Gutenberg
	String longmsg = "Stately, plump Buck Mulligan came from the stairhead,"+
	" bearing a bowl of lather on which a mirror and a razor lay crossed. "+
	"A yellow dressinggown, ungirdled, was sustained gently behind him on "+
	"the mild morning air. He held the bowl aloft and intoned:\n\n" +
	"--_Introibo ad altare Dei_.\n\n" + "Halted, he peered down the dark "+
	"winding stairs and called out coarsely:\n\n" + "--Come up, Kinch! Come"+
	" up, you fearful jesuit!\n\n Solemnly he came forward and mounted the round"+
	"gunrest. He faced about and blessed gravely thrice the tower, the "+
	"surrounding land and the awaking mountains. Then, catching sight of "+
	"Stephen Dedalus, he bent towards him and made rapid crosses in the air, "+
	"gurgling in his throat and shaking his head. Stephen Dedalus, displeased "+
	"and sleepy, leaned his arms on the top of the staircase and looked coldly "+
	"at the shaking gurgling face that blessed him, equine in its length, and "+
	"at the light untonsured hair, grained and hued like pale oak.\n\n"+
	"Buck Mulligan peeped an instant under the mirror and then covered the "+
	"bowl smartly.\n\n--Back to barracks! he said sternly.\n...\n\n"+
	"-by James Joyce, from Ulysses at Project Gutenberg";
	
	Messagebox.show(longmsg, "Ulysses", Messagebox.OK, Messagebox.INFORMATION);
]]>
</zscript>
		""";

		runZTL(zscript,
			() => {
				verifyImage();
			});
	}
}
