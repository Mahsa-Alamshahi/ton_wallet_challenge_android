package com.ton_blockchain.ton_wallet_challenge.presentation.qr_code_scanner_screen

import android.content.Context
import android.widget.Toast
import androidx.camera.core.ExperimentalGetImage
import androidx.camera.core.ImageAnalysis
import androidx.camera.core.ImageProxy
import com.google.mlkit.vision.barcode.BarcodeScannerOptions
import com.google.mlkit.vision.barcode.BarcodeScanning
import com.google.mlkit.vision.barcode.common.Barcode
import com.google.mlkit.vision.common.InputImage

@ExperimentalGetImage
class BarcodeAnalyser(
    val callback: (String) -> Unit,
    val context: Context
) : ImageAnalysis.Analyzer {


    override fun analyze(imageProxy: ImageProxy) {
        val options = BarcodeScannerOptions.Builder()
            .setBarcodeFormats(Barcode.FORMAT_QR_CODE)
            .build()

        val scanner = BarcodeScanning.getClient(options)
        val mediaImage = imageProxy.image
        mediaImage?.let {
            val image = InputImage.fromMediaImage(mediaImage, imageProxy.imageInfo.rotationDegrees)

           val result = scanner.process(image)
                .addOnSuccessListener { barcodes ->
                    if (barcodes.size > 0) {
//                        callback()
                    }
                    for (barcode in barcodes) {
                        //For Android Emulator Only
                        //barcodeListener(barcode.rawValue ?: "", image.bitmapInternal!!)
                        callback(barcode.rawValue ?: "")
                        Toast.makeText(
                            context,
                            "Value: " + barcode.rawValue,
                            Toast.LENGTH_SHORT
                        )
                            .show()
                        imageProxy.close()
                    }
                }
                .addOnFailureListener {
                    // Task failed with an exception
                    // ...
                }
//            callback(result.toString())
        }
        imageProxy.close()
    }
}