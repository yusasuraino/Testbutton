/*
The MIT License (MIT)Copyright (c) 2013-2015 Bearded Hen

Permission is hereby granted, free of charge, to any person obtaining a copy of
this software and associated documentation files (the "Software"), to deal in
the Software without restriction, including without limitation the rights to
use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of
the Software, and to permit persons to whom the Software is furnished to do so,
subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS
FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR
COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER
IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN
CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.</td>
*/


package com.example.yuichiorimo.testbutton;

import android.app.Application;
import android.os.Build;
import android.util.Log;

import com.beardedhen.androidbootstrap.TypefaceProvider;
import io.repro.android.Repro;

/**
 * Created by yuichiorimo on 2017/08/12.
 */

public class TestBootstrap extends Application {
    @Override public void onCreate() {
        super.onCreate();
        TypefaceProvider.registerDefaultIconSets();
        // Setup Repro
        Repro.setup(this, "a9a57d57-231d-4143-a7e5-0c82e1453eb8");

    }
    private void printModel() {
        Log.i("DemoApp", "Model Name : " + Build.MODEL);
    }

}




