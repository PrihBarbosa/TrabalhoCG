#version 130
out vec4 color;

void main(){
  float luzAmb = 0.3;
  color = vec4(1,0,0,1);
  color*=luzAmb;
}