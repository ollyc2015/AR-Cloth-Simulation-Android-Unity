# AR Cloth Simulation using Unity as a library in a Native Android Project
An experimental project investigating the limitations and benefits of using Unity AR Core as a library in a native Android Project.

# Motivation
I was really intested in figuring out a way of animating complex mesh transformations found in cloth simulation in AR within native Android. I found that native Android AR core had limitations due to how .obj were transformed during the model-loading process. This applied a huge amount of strain on the devices RAM, which eventually caused crashes when loading around 100 .obj. The attempt can be found https://github.com/ollyc2015/object-sceneform-animation which is rough and ready - master branch consists of the whole project and viewmodel_livedata demos batch loading of models.

# Outcome
I am please to say that using this approch I have been able to accomplish all the tasks that I set out to achieve. It is possible to animate using .obj.  

# Features include
- Change between scenes (animations) using async methods 
- Dynamically change textures 
- Change the scale of the animation 
- Play, pause and scrub through the animation using a Seeker Bar

# Demo
https://youtu.be/IAMfL32O08A
