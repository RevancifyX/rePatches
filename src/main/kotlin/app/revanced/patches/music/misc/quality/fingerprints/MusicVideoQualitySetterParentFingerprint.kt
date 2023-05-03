package app.revanced.patches.music.misc.quality.fingerprints

import app.revanced.patcher.fingerprint.method.impl.MethodFingerprint
import app.revanced.patches.music.misc.resourceid.patch.SharedResourceIdPatch
import org.jf.dexlib2.Opcode
import org.jf.dexlib2.iface.instruction.WideLiteralInstruction

object MusicVideoQualitySetterParentFingerprint : MethodFingerprint(
    returnType = "V",
    parameters = listOf("L"),
    customFingerprint = { methodDef ->
        methodDef.implementation?.instructions?.any {
            it.opcode.ordinal == Opcode.CONST.ordinal &&
                    (it as? WideLiteralInstruction)?.wideLiteral == SharedResourceIdPatch.qualityAutoLabelId
        } == true
    }
)