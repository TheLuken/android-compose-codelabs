/*
 * Copyright 2020 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.samples.apps.sunflower.plantdetail

import android.content.res.Configuration
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.google.samples.apps.sunflower.R
import com.google.samples.apps.sunflower.databinding.FragmentPlantDetailBinding

class PlantDetailDescription: Fragment(){
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<com.google.samples.apps.sunflower.databinding.FragmentPlantDetailBinding>(
            inflater, R.layout.fragment_plant_detail, container, false
        ).apply {
            composeView.setContent {
                // You're in Compose world!
                MaterialTheme {
                    PlantDetailDescription()
                }
            }
        }

        return binding.root
    }

    @Composable
    fun PlantDetailDescription() {
        Surface {
            Text("Hello Compose")
        }
    }

    @Composable
    fun PlantName(name: String){
        Text(
            text = name,
            style = MaterialTheme.typography.h5,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = dimensionResource(R.dimen.margin_small))
                .wrapContentWidth(Alignment.CenterHorizontally)
        )
    }

    //Parte per la preview
    @Preview(name = "Light Mode")
    @Preview(
        uiMode = Configuration.UI_MODE_NIGHT_YES,
        showBackground = true,
        name = "Dark Mode"
    )
    @Composable
    fun PreviewConversation() {
        MaterialTheme {
            PlantDetailDescription()
        }
    }

    @Preview
    @Composable
    private fun PlantNamePreview() {
        MaterialTheme {
            PlantName("Apple")
        }
    }
}
