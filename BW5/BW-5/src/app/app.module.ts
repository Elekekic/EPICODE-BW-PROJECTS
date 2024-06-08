import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { Route, RouterModule } from '@angular/router';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { FormsModule } from '@angular/forms';


import { AppComponent } from './app.component';
import { NavbarComponent } from './components/navbar/navbar.component';
import { HomeComponent } from './components/home/home.component';
import { LoginComponent } from './auth/login/login.component';
import { SignupComponent } from './auth/signup/signup.component';
import { TokenInterceptor } from './auth/token.interceptor';
import { AuthService } from './auth/auth.service';
import { FattureComponent } from './components/fatture/fatture.component';
import { LandingPageComponent } from './components/landing-page/landing-page.component';
import { FattureClienteComponent } from './components/fatture-cliente/fatture-cliente.component';
import { AggiungiFattureComponent } from './components/aggiungi-fatture/aggiungi-fatture.component';

const routes: Route[] = [
  {
    path: '',
    component: LandingPageComponent,
  },
  {
    path: 'home',
    component: HomeComponent,
  },
  {
    path: 'login',
    component: LoginComponent,
  },
  {
    path: 'signup',
    component: SignupComponent,
  },
  {
    path: 'fatture',
    component: FattureComponent,
  },
  {
    path: 'fatture-cliente/:id',
    component: FattureClienteComponent,
  },
  {
    path: 'aggiungi-fatture',
    component: AggiungiFattureComponent,
  }
]

@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    HomeComponent,
    LoginComponent,
    SignupComponent,
    FattureComponent,
    LandingPageComponent,
    FattureClienteComponent,
    AggiungiFattureComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule, 
    FormsModule, 
    RouterModule.forRoot(routes),
  ],
  providers: [
    {
      provide: HTTP_INTERCEPTORS,
      useClass: TokenInterceptor,
      multi: true
    },
    AuthService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
