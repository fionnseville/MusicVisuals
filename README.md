# Music Visualiser Project

Name:Cathal Small, Fionn Seville, Lilja O'Byrne

Student Number: C21414822, C21383891, C21385033

## Instructions
- Fork this repository and use it a starter project for your assignment
- Create a new package named your student number and put all your code in this package.
- You should start by creating a subclass of ie.tudublin.Visual
- There is an example visualiser called MyVisual in the example package
- Check out the WaveForm and AudioBandsVisual for examples of how to call the Processing functions from other classes that are not subclasses of PApplet

# Description of the assignment

## CATHAL:
For my portion of the assignment, I was in charge of setting up the files with polymorphism as well as creating two visuals. The first of these visuals was Spiral.java. The circles that make up this spiral all change size based on the SmoothedAmplitude with the rotation of it being mapped to SmoothAmplitude too. The second visual I made was Bloom.java, which was done to represent a flower. The flower is made up of rectangles that scale and rotate in sync to the music. There is also a colour change occurning at the centre of the flower, which creates a pistil. This pistil is also synced to the music.

# Instructions
## KeyPressed
A KeyPressed function is used to swap between the visuals
Pressing a number between 1 and 6 will change the visual playing at that time
Pressing space will pause the song and pressing it again will resume from where you paused it.
If you want to restart the song, you can press r or R.

# How it works
## CATHAL:
### Spiral.java: 
This uses two for loops,each of which contribute a different aspect to the spiral. The outer loop sets the number of "strands" of the inner loops by rotating the whole visual by a fixed constantly increasing amount. By rasing or lowering the value of the index variable "a" in the for loop, you can increase or decrease the amount of spirals and change the pattern created by the rotations. The outer for loop also maps the angle of rotation to the SmoothedAmplitude allowing for the rotation of the spirals to sync to the music. The inner for loops are used to create the spiral itself. Each iteration will draw a circle, the diameter and colour of which is synced to the song, and rotate by the angle calculated in the outer for loop. BeatDetect is used to change the colour range of the spiral too. When a kick is detected in the song, the spiral will flash with a different range of colours.

### Bloom.java:
This visual uses one for loop to draw rectangles to the screen. These rectangles are synced to the music using the SmoothedAmplitude. These rectangles are then rotated, in sync to the music, and its this rotation that creates the flower like design seen. To make pistil at the centre of the flower, I set the hue to be the audiobuffer.get(i). This synced the colour of the centre of the flower to the music whilst creating a unifrom colour for the rest of the flower. To create the darker edges of the flower, I used map to allow for the audiobuffer size and the colour range to change 'i'. All of this was scaled and the same beat kick function used in Spiral.java was used to change the colour range.

## LILJA:
### Kalidascope:
This visual contains a series of octagons positioned in a circle. These octagons all create one single shape. This is done using TWO_PI and sin and cos.
The shape is then rotated according to the frame count.
On each beat the stroke weight increases and the entire shape beats outwards.
 
### Cubes:
This visual contains several 3D boxes converged in the centre. At first the shape is large, filling up the screen and it gradually gets smaller until it stays a specific size. Surrounding these boxes are rectangles that are being ''sucked'' into the centre, imitating a black hole. The idea was that the cube structure is pulling all the rectangles into it. There are also small circles that surround the boxes and slowing fall out from it.
This visual is done by using a timer and lerp function to set the size change of the boxes.
The position of the boxes are set on angles so that they are not piled on top of one another. 
The shape is rotated and the angle is incremented so that there is constant movement.

# What I am most proud of in the assignment

## CATHAL:
The part of this assignment I'm most proud of would have to be setting up the files to use polymorphism. As much fun as it was creating the spiral and figuring out the maths for it and the bloom visual, I have always been quite good at trigonometry, so I don't feel I learned as much from those as I did with the polymorphism. Before this assignment, I had no exposure to polymorphism in code and had no knowledge of how to implement it. However, after plenty of trial and error as well as tons of research, I managed to implement it perfectly and ensured that it was simple to use for the other members in my group. It left me feeling satisfied as I managed to do something that I previously wouldn't have tried doing because I thought it'd be too difficult. I feel like if I needed to use polymorphism anywhere in the future, I'd be able to implement it with no hassle.

## LILJA:
I am most proud of the cubic visual. I spent awhile changing around the variables and trying different things to get to the shape I was happy with. I enjoyed playing around with 3D shapes and am quite proud how it turned out.

# What I Learned:
## CATHAL:
I learned quite a lot in this assignment. As I said earlier, I learned a lot about how polymorphism works and how to implement it for a project like this, but I also learned how to use Git and GitHub to manage a project like this. I'd never used Git or GitHub before this module so I had no experience with it going in. However, I now feel quite comfortable using it and now know how to solve merge conflicts and deal with pull requests. I also learned a great deal more about processing and the ways it can be used to create art. Finally, I learned that theres a limit on how many times you can hear Stayin Alive before it gets a bit annoying.

## LILJA:
During the project I was able to see the effects of maths visualised on screen. It was interesting to see how different maths functions behaved visually and I learned a lot from it.

# Markdown Tutorial

This is *emphasis*

This is a bulleted list

- Item
- Item

This is a numbered list

1. Item
1. Item

This is a [hyperlink](http://bryanduggan.org)

# Headings
## Headings
#### Headings
##### Headings

This is code:

```Java
public void render()
{
	ui.noFill();
	ui.stroke(255);
	ui.rect(x, y, width, height);
	ui.textAlign(PApplet.CENTER, PApplet.CENTER);
	ui.text(text, x + width * 0.5f, y + height * 0.5f);
}
```

So is this without specifying the language:

```
public void render()
{
	ui.noFill();
	ui.stroke(255);
	ui.rect(x, y, width, height);
	ui.textAlign(PApplet.CENTER, PApplet.CENTER);
	ui.text(text, x + width * 0.5f, y + height * 0.5f);
}
```

This is an image using a relative URL:

![An image](images/p8.png)

This is an image using an absolute URL:

![A different image](https://bryanduggandotorg.files.wordpress.com/2019/02/infinite-forms-00045.png?w=595&h=&zoom=2)

This is a youtube video:

[![YouTube](http://img.youtube.com/vi/J2kHSSFA4NU/0.jpg)](https://www.youtube.com/watch?v=J2kHSSFA4NU)

This is a table:

| Heading 1 | Heading 2 |
|-----------|-----------|
|Some stuff | Some more stuff in this column |
|Some stuff | Some more stuff in this column |
|Some stuff | Some more stuff in this column |
|Some stuff | Some more stuff in this column |

