import { NgModule } from '@angular/core';

import { UserRoutingModule } from './user-routing.module';
import { SettingsComponent } from './components/settings/settings.component';
import {SharedModule} from "../../shared/shared.module";
import {UserService} from "./service/user.service";

@NgModule({
  imports: [
    SharedModule,
    UserRoutingModule
  ],
  declarations: [SettingsComponent],
  providers: [UserService]
})
export class UserModule { }
