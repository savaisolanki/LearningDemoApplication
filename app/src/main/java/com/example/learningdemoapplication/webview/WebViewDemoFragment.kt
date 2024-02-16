package com.example.learningdemoapplication.webview

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.learningdemoapplication.R
import com.example.learningdemoapplication.databinding.FragmentWebViewDemoBinding


class WebViewDemoFragment : Fragment() {

    private lateinit var binding: FragmentWebViewDemoBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_web_view_demo, container, false)
        return binding.root
    }


    @SuppressLint("SetJavaScriptEnabled")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val text = "  <div>    <div>      <table>      " +
                "  <tbody>          <tr>            <td style='color: black;'>Diaper Type</td>    " +
                "        <td style='color: black;'>Tape</td>          </tr>          <tr>     " +
                "       <td style='color: black;'>Size</td>            <td style='color: black;'>2-5kg</td>   " +
                "       </tr>                  <tr>        " +
                "    <td style='color: black;'>Recommended Age</td>          " +
                "  <td style='color: black;'>New Born</td>          </tr>     " +
                "       <tr>            <td style='color: black;'>Department</td>   " +
                "         <td style='color: black;'>Baby Unisex</td>          </tr>          " +
                "  <tr>            <td style='color: black;'>Item Pack Quantity</td>       " +
                "     <td style='color: black;'>Single</td>          </tr>          <tr>   " +
                "         <td style='color: black;'>Diaper Count</td>            <td style='color: black;'>66 Diapers</td>  " +
                "        </tr>          <tr>            <td style='color: black;'>Certification</td>            <td style='color: black;'>Dermatest®</td>          </tr>          <tr>            <td style='color: black;'>Manufactured In</td>            " +
                "<td style='color: black;'>United Arab Emirates</td>       " +
                "   </tr>         </tbody>      </table>    </div>  </div>"

        binding.webView.loadData(text, "text/html", "UTF-8")
        binding.webView.settings.javaScriptEnabled = true

        if (getWordCount(text) > 60) {
            setWebViewHeight(50)
            binding.btnReadMoreReadLess.text = "Read More"
            binding.btnReadMoreReadLess.visibility = View.VISIBLE
        } else {
            setWebViewHeight(ViewGroup.LayoutParams.MATCH_PARENT)
            binding.btnReadMoreReadLess.visibility = View.GONE
        }

        binding.btnReadMoreReadLess.setOnClickListener {
            if (binding.btnReadMoreReadLess.text == "Read More") {
                setWebViewHeight(ViewGroup.LayoutParams.MATCH_PARENT)
                binding.btnReadMoreReadLess.text = "Read Less"
            } else {
                setWebViewHeight(50)
                binding.btnReadMoreReadLess.text = "Read More"
            }
        }
    }

    private fun setWebViewHeight(height: Int) {
        val params = binding.webView.layoutParams as ConstraintLayout.LayoutParams
        params.height = dpToPx(height)
        binding.webView.layoutParams = params
    }

    private fun dpToPx(dp: Int): Int {
        val density = resources.displayMetrics.density
        return (dp * density).toInt()
    }

    private fun getWordCount(test: String): Int {
        val cleanedText = test.replace(Regex("<p>|</p>"), " ") // Replace <p> and </p> with spaces
        val words = cleanedText.split("\\s+|\\n+".toRegex())
        return words.count()
    }

}