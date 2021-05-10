package stomee.social

import net.kyori.adventure.text.format.TextColor
import org.jetbrains.annotations.Contract
import kotlin.math.round

object StomeeColors {

    const val blue = "#0c6dec"
    const val middle = "#5f0dec"
    const val purple = "#a60efe"

    val blueColor = TextColor.fromCSSHexString(blue)!!
    val middleColor = TextColor.fromCSSHexString(middle)!!
    val purpleColor = TextColor.fromCSSHexString(purple)!!


}

@Contract(pure = true)
fun TextColor.lighten(amount: Double) = TextColor.color(
    round(red() * (1 + amount)).toInt(),
    round(blue() * (1 + amount)).toInt(),
    round(green() * (1 + amount)).toInt()
)