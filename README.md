
# Softsuave - Emoji Sketcher
![](https://img.shields.io/badge/Android-3DDC84?style=for-the-badge&logo=android&logoColor=white)  [![](https://jitpack.io/v/softsuave-tech-matrix/emoji_sketcher.svg)](https://jitpack.io/#softsuave-tech-matrix/emoji_sketcher)
# Introduction
This Android library aims to provide an emoji quickily to user by drawing  the emoji. Emojis have become an integral part of digital communication, adding emotion and context to text-based messages. This repository aims to provide users with tools and features to easily sketch, customize, and manage their own emojis.

With a user-friendly interface, this project is designed to be accessible to a wide range of users, from casual emoji enthusiasts to designers needing customized emojis for specific purposes. The ability to save and share creations adds practicality and social interaction to the emoji creation process.

Overall, this repository serves as a platform for creativity and expression through the creation and customization of emojis, enhancing the visual language of digital communication.


## Features

- **Emoji Sketching**: The repository seems to focus on creating and editing emojis
- **Customization**: Users are able to customize the emojis by creating or changing the sketche drawn.
- **Undo/Redo**: It may have functionality to undo and redo changes made during the emoji creation process.
- **Save and Share**: Users might be able to save their creations locally or share them directly through social media or messaging platforms.
- **Canvas**: It probably has a canvas where users can draw their emojis.
- **Responsive Design**: The UI might be designed to work well on different screen sizes and devices.


## Quick Setup

This section explains how to setup *emoji sketcher* as a library for your Android applications.

#### 1. Include library

###### a. Android Studio (AS)

* Modify the *settings.gradle.kts* file in the *project* module of your Android project by adding the following *compile* line in the *repositories* body:

```gradle
// settings.gradle.kts
dependencyResolutionManagement {
    repositories {
        maven("https://jitpack.io")
    }
}
```

* Modify the *build.gradle* file in the *app* module of your Android project by adding the following *compile* line in the *dependencies* body:
``` gradle
dependencies {
    implementation ("com.github.softsuave-tech-matrix:emoji_sketcher:Tag")
}
``` 
* Resync your project to apply changes.


#### 2. Android Manifest

Modify the *Android Manifest* of your application by adding a couple of **required permissions**:
``` xml
<manifest>

	<uses-permission android:name="android.permission.INTERNET" />
    
	...
</manifest>
```

## Quick example of use

This quick use case gives you a taste on how to use *emoji-sketcher* once you have added it to your project.
```groovy

class MainActivity : AppCompatActivity(), GetSelectedEmoji {
    private var _binding: MainActivityLayoutBinding? = null
    private val binding by lazy { _binding!! }

        private var emojiSketcher: EmojiSketcher? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        _binding = MainActivityLayoutBinding.inflate(layoutInflater)
        setContentView(binding.root)
        super.onCreate(savedInstanceState)
        binding.getEmojiButton.setOnClickListener {
            //building
            emojiSketcher = EmojiSketcherBuilder(this, this).build()
            //show the dialog
            emojiSketcher?.show()
        }
    }

    override fun getSelectedEmoji(emoji: String) {
        binding.emojiIcon.visibility = View.VISIBLE
        binding.emojiIcon.text = emoji
    }
}                                                                                
```

## Contribution Guidelines
We welcome contributions to enhance this project! Before making significant changes, please open an issue to discuss your ideas.

When contributing, please ensure the following:

Open an issue to discuss major changes beforehand.
Update tests to reflect any modifications.
Follow coding conventions and project standards.
Your contributions help improve the project for everyone.

Thank you for your support!

## Feedback

If you have any feedback, please reach out to us at techmatrix@softsuave.com

## Authors

- [@softsuave-tech-matrix](https://github.com/softsuave-tech-matrix)



 