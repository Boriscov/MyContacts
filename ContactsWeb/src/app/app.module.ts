import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ContactsComponent } from './contacts/contacts.component';
import {RouterModule, Routes} from '@angular/router';
import { AboutComponent } from './about/about.component';
import {HttpClient, HttpClientModule} from '@angular/common/http';
import {ContactsService} from '../services/contacts.service';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import { NewContactComponent } from './new-contact/new-contact.component';
import { NewContact2Component } from './new-contact2/new-contact2.component';
import { EditContactComponent } from './edit-contact/edit-contact.component';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { HomeComponent } from './home/home.component';
import { AlertComponent } from './alert/alert.component';
import {HTTP_INTERCEPTORS} from '@angular/common/http';
import {AuthGuard, ErrorInterceptor, fakeBackendProvider, JwtInterceptor} from './helpers';

const appRoutes: Routes = [

  { path: '', component: HomeComponent, canActivate: [AuthGuard] },
  { path: 'login', component: LoginComponent },
  { path: 'register', component: RegisterComponent },

  // otherwise redirect to home
  // { path: '**', redirectTo: '' }

  {path: 'about', component: AboutComponent},
  {path: 'contacts', component: ContactsComponent },
  // a path call with a parameter id
  {path: 'editContact/:id', component: EditContactComponent },
  {path: 'new-contact', component: NewContact2Component },
  // after defining route, one define a default root with the default path(/about) and the art one have to give the path(full)
  {path: '', redirectTo: '/about' , pathMatch: 'full' }
  ];
@NgModule({
  declarations: [
    AppComponent,
    ContactsComponent,
    AboutComponent,
    NewContactComponent,
    NewContact2Component,
    EditContactComponent,
    LoginComponent,
    RegisterComponent,
    HomeComponent,
    AlertComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    RouterModule.forRoot(appRoutes),
    HttpClientModule,
    ReactiveFormsModule,
    FormsModule
  ],
  providers: [ContactsService,
    { provide: HTTP_INTERCEPTORS, useClass: JwtInterceptor, multi: true },
    { provide: HTTP_INTERCEPTORS, useClass: ErrorInterceptor, multi: true },

    // provider used to create fake backend
    fakeBackendProvider],
  bootstrap: [AppComponent]
})
export class AppModule { }
